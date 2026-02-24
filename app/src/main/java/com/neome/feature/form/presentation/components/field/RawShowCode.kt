package com.neome.feature.form.presentation.components.field

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.common.BitMatrix
import com.google.zxing.oned.Code128Writer
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import com.neome.api.meta.base.Types.EnumDefnCodeType

private val DEFAULT_QR_SIZE = 100.dp
private val DEFAULT_BARCODE_WIDTH = 200.dp
private val DEFAULT_BARCODE_HEIGHT = 64.dp

/**
 * Raw component that renders a QR code or barcode from a given string value.
 *
 * Uses ZXing to encode the [value] into the visual code determined by [codeType].
 * Returns nothing if [value] is null or blank, or if [codeType] is null.
 *
 * @param value The string to encode as a QR code or barcode
 * @param codeType The type of code to render (qrCode or barCode)
 * @param qrSize Size of the QR code image (width and height). Defaults to 100.dp
 * @param barcodeWidth Width of the barcode image. Defaults to 200.dp
 * @param barcodeHeight Height of the barcode image. Defaults to 64.dp
 * @param modifier Modifier for the outer container
 */
@Composable
fun RawShowCode(
    value: String?,
    codeType: EnumDefnCodeType?,
    qrSize: Dp = DEFAULT_QR_SIZE,
    barcodeWidth: Dp = DEFAULT_BARCODE_WIDTH,
    barcodeHeight: Dp = DEFAULT_BARCODE_HEIGHT,
    modifier: Modifier = Modifier
) {
    if (value.isNullOrBlank() || codeType == null) return

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        when (codeType) {
            EnumDefnCodeType.qrCode -> {
                QrCodeImage(
                    value = value,
                    size = qrSize
                )
            }

            EnumDefnCodeType.barCode -> {
                BarcodeImage(
                    value = value,
                    width = barcodeWidth,
                    height = barcodeHeight
                )
            }
        }
    }
}

/**
 * Renders a QR code image from the given [value].
 */
@Composable
private fun QrCodeImage(
    value: String,
    size: Dp,
    modifier: Modifier = Modifier
) {
    val sizePx = with(androidx.compose.ui.platform.LocalDensity.current) { size.roundToPx() }

    val bitmap = remember(value, sizePx) {
        generateQrBitmap(value, sizePx)
    }

    if (bitmap != null) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "QR Code",
            modifier = modifier.size(size),
            contentScale = ContentScale.Fit
        )
    }
}

/**
 * Renders a barcode (CODE_128) image from the given [value].
 */
@Composable
private fun BarcodeImage(
    value: String,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier
) {
    val density = androidx.compose.ui.platform.LocalDensity.current
    val widthPx = with(density) { width.roundToPx() }
    val heightPx = with(density) { height.roundToPx() }

    val bitmap = remember(value, widthPx, heightPx) {
        generateBarcodeBitmap(value, widthPx, heightPx)
    }

    if (bitmap != null) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "Barcode",
            modifier = modifier
                .width(width)
                .height(height),
            contentScale = ContentScale.Fit
        )
    }
}

/**
 * Generates a QR code [Bitmap] from [content] at the given [sizePx].
 * Uses error correction level H (highest) for better readability.
 * Returns null if encoding fails.
 */
private fun generateQrBitmap(content: String, sizePx: Int): Bitmap? {
    return try {
        val hints = mapOf(
            EncodeHintType.ERROR_CORRECTION to ErrorCorrectionLevel.H,
            EncodeHintType.MARGIN to 0
        )
        val bitMatrix: BitMatrix = QRCodeWriter().encode(
            content,
            BarcodeFormat.QR_CODE,
            sizePx,
            sizePx,
            hints
        )
        bitMatrixToBitmap(bitMatrix)
    } catch (_: Exception) {
        null
    }
}

/**
 * Generates a CODE_128 barcode [Bitmap] from [content] at the given dimensions.
 * Returns null if encoding fails.
 */
private fun generateBarcodeBitmap(content: String, widthPx: Int, heightPx: Int): Bitmap? {
    return try {
        val hints = mapOf(
            EncodeHintType.MARGIN to 0
        )
        val bitMatrix: BitMatrix = Code128Writer().encode(
            content,
            BarcodeFormat.CODE_128,
            widthPx,
            heightPx,
            hints
        )
        bitMatrixToBitmap(bitMatrix)
    } catch (_: Exception) {
        null
    }
}

/**
 * Converts a ZXing [BitMatrix] into an Android [Bitmap].
 * Uses black foreground on white background for maximum scan readability.
 */
private fun bitMatrixToBitmap(bitMatrix: BitMatrix): Bitmap {
    val width = bitMatrix.width
    val height = bitMatrix.height
    val fgColor = Color.Black.toArgb()
    val bgColor = Color.White.toArgb()

    val pixels = IntArray(width * height) { index ->
        val x = index % width
        val y = index / width
        if (bitMatrix[x, y]) fgColor else bgColor
    }

    return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888).apply {
        setPixels(pixels, 0, width, 0, 0, width, height)
    }
}
