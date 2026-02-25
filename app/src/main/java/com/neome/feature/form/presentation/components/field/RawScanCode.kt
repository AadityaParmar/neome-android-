package com.neome.feature.form.presentation.components.field

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.zxing.BarcodeFormat
import com.google.zxing.BinaryBitmap
import com.google.zxing.DecodeHintType
import com.google.zxing.MultiFormatReader
import com.google.zxing.PlanarYUVLuminanceSource
import com.google.zxing.common.HybridBinarizer
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

// =============================================================================
// Public API — ScanCodeFormat
// =============================================================================

/**
 * Supported scan code formats for [RawScanCode].
 *
 * Maps each logical code type to a ZXing [BarcodeFormat] used by the scanner.
 *
 * **QR-type formats:**
 * - [Qr] — Standard QR code
 * - [Pdf417] — PDF-417 stacked barcode
 * - [Aztec] — Aztec 2D barcode
 * - [DataMatrix] — Data Matrix 2D barcode
 *
 * **Barcode formats:**
 * - [Code128] — Code 128
 * - [Code39] — Code 39
 * - [Code93] — Code 93
 * - [Ean13] — EAN-13
 * - [Ean8] — EAN-8
 * - [UpcE] — UPC-E
 * - [UpcA] — UPC-A
 * - [Itf] — Interleaved 2 of 5 (ITF)
 * - [Codabar] — Codabar
 */
enum class ScanCodeFormat(internal val barcodeFormat: BarcodeFormat) {
    // QR-type formats
    Qr(BarcodeFormat.QR_CODE),
    Pdf417(BarcodeFormat.PDF_417),
    Aztec(BarcodeFormat.AZTEC),
    DataMatrix(BarcodeFormat.DATA_MATRIX),

    // Barcode formats
    Code128(BarcodeFormat.CODE_128),
    Code39(BarcodeFormat.CODE_39),
    Code93(BarcodeFormat.CODE_93),
    Ean13(BarcodeFormat.EAN_13),
    Ean8(BarcodeFormat.EAN_8),
    UpcE(BarcodeFormat.UPC_E),
    UpcA(BarcodeFormat.UPC_A),
    Itf(BarcodeFormat.ITF),
    Codabar(BarcodeFormat.CODABAR);

    companion object {
        /** All QR-type formats. */
        val qrCodeTypes: List<ScanCodeFormat> = listOf(Qr, Pdf417, Aztec, DataMatrix)

        /** All barcode formats. */
        val barCodeTypes: List<ScanCodeFormat> = listOf(
            Code128, Code39, Code93, Ean13, Ean8, UpcE, UpcA, Itf, Codabar
        )

        /** Every supported format. */
        val all: List<ScanCodeFormat> = entries.toList()
    }
}

// =============================================================================
// Public API — RawScanCode
// =============================================================================

/**
 * Raw component that opens the camera and scans for barcodes / QR codes.
 *
 * Shows a full-screen camera preview with a viewfinder overlay. When a code
 * matching one of the [codeTypes] is detected, [onScanned] is called once with
 * the decoded string value and the scanner pauses. The caller should then hide
 * or dismiss this composable.
 *
 * **Usage:**
 * ```kotlin
 * var showScanner by remember { mutableStateOf(false) }
 * var scannedValue by remember { mutableStateOf<String?>(null) }
 *
 * if (showScanner) {
 *     RawScanCode(
 *         codeTypes = ScanCodeFormat.all,
 *         onScanned = { value ->
 *             scannedValue = value
 *             showScanner = false
 *         },
 *         onDismiss = { showScanner = false }
 *     )
 * }
 * ```
 *
 * @param codeTypes List of [ScanCodeFormat] to accept. Pass [ScanCodeFormat.all]
 *   for unrestricted scanning, or a subset to restrict (e.g., [ScanCodeFormat.qrCodeTypes]).
 * @param onScanned Called once when a matching code is successfully decoded.
 *   Receives the decoded string value.
 * @param onDismiss Called when the user presses back / close to cancel scanning.
 * @param modifier Modifier applied to the scanner root layout.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RawScanCode(
    codeTypes: List<ScanCodeFormat>,
    onScanned: (scannedValue: String) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    // Permission state
    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasCameraPermission = granted
        if (!granted) onDismiss()
    }

    // Request permission on first composition if not already granted
    LaunchedEffect(Unit) {
        if (!hasCameraPermission) {
            permissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    if (!hasCameraPermission) return

    // Flash state
    var isFlashOn by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Scan Code") },
                navigationIcon = {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Close scanner"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { isFlashOn = !isFlashOn }) {
                        Icon(
                            imageVector = if (isFlashOn) {
                                Icons.Default.FlashOn
                            } else {
                                Icons.Default.FlashOff
                            },
                            contentDescription = if (isFlashOn) "Turn off flash" else "Turn on flash"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black.copy(alpha = 0.6f),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        },
        containerColor = Color.Black
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Camera preview with barcode analysis
            ScannerCameraPreview(
                codeTypes = codeTypes,
                isFlashOn = isFlashOn,
                onScanned = onScanned,
                modifier = Modifier.fillMaxSize()
            )

            // Viewfinder overlay
            ScannerOverlay(
                modifier = Modifier.fillMaxSize()
            )

            // Hint text at the bottom
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Point camera at a code to scan",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

// =============================================================================
// Internal — Camera Preview with ImageAnalysis
// =============================================================================

/**
 * CameraX preview composable with real-time barcode scanning via [ImageAnalysis].
 *
 * Sets up the back camera with a [Preview] and an [ImageAnalysis] use case.
 * Each frame is analyzed by [BarcodeScanAnalyzer] which attempts to decode
 * using ZXing's [MultiFormatReader] restricted to the given [codeTypes].
 */
@Composable
private fun ScannerCameraPreview(
    codeTypes: List<ScanCodeFormat>,
    isFlashOn: Boolean,
    onScanned: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }

    // Atomic flag to ensure onScanned fires only once
    val hasScanned = remember { AtomicBoolean(false) }

    val previewView = remember { PreviewView(context) }

    // Track camera reference for flash control
    var camera by remember { mutableStateOf<androidx.camera.core.Camera?>(null) }

    // Toggle torch when flash state changes
    LaunchedEffect(isFlashOn, camera) {
        camera?.cameraControl?.enableTorch(isFlashOn)
    }

    LaunchedEffect(codeTypes) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

        cameraProviderFuture.addListener({
            try {
                val cameraProvider = cameraProviderFuture.get()

                val preview = Preview.Builder()
                    .build()
                    .also { it.surfaceProvider = previewView.surfaceProvider }

                val imageAnalysis = ImageAnalysis.Builder()
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()
                    .also { analysis ->
                        analysis.setAnalyzer(cameraExecutor, BarcodeScanAnalyzer(
                            allowedFormats = codeTypes.map { it.barcodeFormat },
                            onCodeDetected = { decodedText ->
                                if (hasScanned.compareAndSet(false, true)) {
                                    onScanned(decodedText)
                                }
                            }
                        ))
                    }

                cameraProvider.unbindAll()
                camera = cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    CameraSelector.DEFAULT_BACK_CAMERA,
                    preview,
                    imageAnalysis
                )
            } catch (_: Exception) {
                // Camera initialization failed — UI stays blank, user can dismiss
            }
        }, ContextCompat.getMainExecutor(context))
    }

    DisposableEffect(Unit) {
        onDispose {
            cameraExecutor.shutdown()
        }
    }

    AndroidView(
        factory = { previewView },
        modifier = modifier
    )
}

// =============================================================================
// Internal — Scanner Overlay
// =============================================================================

/**
 * Draws a semi-transparent overlay with a clear rounded-rectangle viewfinder
 * in the center. Corner brackets are drawn on the viewfinder edges to guide
 * the user.
 */
@Composable
private fun ScannerOverlay(
    modifier: Modifier = Modifier
) {
    val overlayColor = Color.Black.copy(alpha = 0.5f)
    val bracketColor = Color.White
    val bracketStroke = 4.dp

    Canvas(modifier = modifier) {
        val viewfinderSize = size.minDimension * 0.65f
        val viewfinderLeft = (size.width - viewfinderSize) / 2f
        val viewfinderTop = (size.height - viewfinderSize) / 2f
        val cornerRadius = 16f

        val viewfinderRect = Rect(
            offset = Offset(viewfinderLeft, viewfinderTop),
            size = Size(viewfinderSize, viewfinderSize)
        )

        // Draw semi-transparent overlay with viewfinder cut-out
        val cutoutPath = Path().apply {
            addRoundRect(
                RoundRect(
                    rect = viewfinderRect,
                    cornerRadius = CornerRadius(cornerRadius, cornerRadius)
                )
            )
        }

        clipPath(cutoutPath, clipOp = ClipOp.Difference) {
            drawRect(color = overlayColor)
        }

        // Draw corner brackets
        val bracketLength = viewfinderSize * 0.1f
        val strokeWidth = bracketStroke.toPx()

        drawCornerBrackets(
            rect = viewfinderRect,
            bracketLength = bracketLength,
            strokeWidth = strokeWidth,
            color = bracketColor,
            cornerRadius = cornerRadius
        )
    }
}

/**
 * Draws L-shaped corner brackets on all four corners of the given [rect].
 */
private fun DrawScope.drawCornerBrackets(
    rect: Rect,
    bracketLength: Float,
    strokeWidth: Float,
    color: Color,
    cornerRadius: Float
) {
    val stroke = Stroke(width = strokeWidth)
    val cr = cornerRadius

    // Top-left corner
    drawLine(
        color = color,
        start = Offset(rect.left + cr, rect.top),
        end = Offset(rect.left + bracketLength, rect.top),
        strokeWidth = strokeWidth
    )
    drawLine(
        color = color,
        start = Offset(rect.left, rect.top + cr),
        end = Offset(rect.left, rect.top + bracketLength),
        strokeWidth = strokeWidth
    )
    drawArc(
        color = color,
        startAngle = 180f,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = Offset(rect.left, rect.top),
        size = Size(cr * 2, cr * 2),
        style = stroke
    )

    // Top-right corner
    drawLine(
        color = color,
        start = Offset(rect.right - bracketLength, rect.top),
        end = Offset(rect.right - cr, rect.top),
        strokeWidth = strokeWidth
    )
    drawLine(
        color = color,
        start = Offset(rect.right, rect.top + cr),
        end = Offset(rect.right, rect.top + bracketLength),
        strokeWidth = strokeWidth
    )
    drawArc(
        color = color,
        startAngle = 270f,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = Offset(rect.right - cr * 2, rect.top),
        size = Size(cr * 2, cr * 2),
        style = stroke
    )

    // Bottom-left corner
    drawLine(
        color = color,
        start = Offset(rect.left + cr, rect.bottom),
        end = Offset(rect.left + bracketLength, rect.bottom),
        strokeWidth = strokeWidth
    )
    drawLine(
        color = color,
        start = Offset(rect.left, rect.bottom - bracketLength),
        end = Offset(rect.left, rect.bottom - cr),
        strokeWidth = strokeWidth
    )
    drawArc(
        color = color,
        startAngle = 90f,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = Offset(rect.left, rect.bottom - cr * 2),
        size = Size(cr * 2, cr * 2),
        style = stroke
    )

    // Bottom-right corner
    drawLine(
        color = color,
        start = Offset(rect.right - bracketLength, rect.bottom),
        end = Offset(rect.right - cr, rect.bottom),
        strokeWidth = strokeWidth
    )
    drawLine(
        color = color,
        start = Offset(rect.right, rect.bottom - bracketLength),
        end = Offset(rect.right, rect.bottom - cr),
        strokeWidth = strokeWidth
    )
    drawArc(
        color = color,
        startAngle = 0f,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = Offset(rect.right - cr * 2, rect.bottom - cr * 2),
        size = Size(cr * 2, cr * 2),
        style = stroke
    )
}

// =============================================================================
// Internal — ZXing Barcode Analyzer
// =============================================================================

/**
 * CameraX [ImageAnalysis.Analyzer] that decodes barcodes from camera frames
 * using ZXing's [MultiFormatReader].
 *
 * Converts each [ImageProxy] (YUV_420_888) into a ZXing [PlanarYUVLuminanceSource],
 * then attempts to decode using only the [allowedFormats].
 *
 * @param allowedFormats ZXing [BarcodeFormat]s to scan for
 * @param onCodeDetected Called on the analyzer thread when a code is detected.
 *   The caller is responsible for thread-safety (e.g., using [AtomicBoolean]).
 */
private class BarcodeScanAnalyzer(
    allowedFormats: List<BarcodeFormat>,
    private val onCodeDetected: (String) -> Unit
) : ImageAnalysis.Analyzer {

    private val reader = MultiFormatReader().apply {
        val hints = mapOf(
            DecodeHintType.POSSIBLE_FORMATS to allowedFormats,
            DecodeHintType.TRY_HARDER to true,
            DecodeHintType.CHARACTER_SET to "UTF-8"
        )
        setHints(hints)
    }

    override fun analyze(imageProxy: ImageProxy) {
        try {
            val source = imageProxy.toPlanarYUVLuminanceSource() ?: return
            val binaryBitmap = BinaryBitmap(HybridBinarizer(source))
            val result = reader.decodeWithState(binaryBitmap)

            if (result?.text?.isNotBlank() == true) {
                onCodeDetected(result.text)
            }
        } catch (_: Exception) {
            // No code found in this frame — continue scanning
        } finally {
            reader.reset()
            imageProxy.close()
        }
    }
}

// =============================================================================
// Internal — ImageProxy → ZXing conversion
// =============================================================================

/**
 * Converts a CameraX [ImageProxy] (YUV_420_888) to a ZXing [PlanarYUVLuminanceSource].
 *
 * Only the Y (luminance) plane is needed for barcode detection.
 * Returns null if the image format is unsupported.
 */
private fun ImageProxy.toPlanarYUVLuminanceSource(): PlanarYUVLuminanceSource? {
    if (format != android.graphics.ImageFormat.YUV_420_888) return null

    val yPlane = planes[0]
    val yBuffer = yPlane.buffer

    val rowStride = yPlane.rowStride
    val pixelStride = yPlane.pixelStride

    // For most devices pixelStride == 1 and we can use the buffer directly.
    // When pixelStride != 1 we need to unpack the Y data row by row.
    val data: ByteArray
    if (pixelStride == 1 && rowStride == width) {
        // Contiguous buffer — copy directly
        data = ByteArray(yBuffer.remaining())
        yBuffer.get(data)
    } else {
        // Non-contiguous — copy row by row, skipping row padding
        data = ByteArray(width * height)
        var offset = 0
        for (row in 0 until height) {
            yBuffer.position(row * rowStride)
            for (col in 0 until width) {
                data[offset++] = yBuffer.get(col * pixelStride)
            }
        }
    }

    return PlanarYUVLuminanceSource(
        data,
        width,
        height,
        0,
        0,
        width,
        height,
        false
    )
}
