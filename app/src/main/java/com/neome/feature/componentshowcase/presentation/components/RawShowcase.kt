package com.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnCodeType
import com.neome.core.common.parser.ext.RawTextParserUi
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.camera.presentation.components.FullScreenCameraDialog
import com.neome.feature.form.presentation.components.field.RawScanCode
import com.neome.feature.form.presentation.components.field.RawShowCode
import com.neome.feature.form.presentation.components.field.ScanCodeFormat
import com.neome.feature.form.presentation.components.raw.picker.RawPickerMultiSelect
import com.neome.feature.form.presentation.components.raw.picker.RawPickerSingleSelect

@Composable
fun RawShowcase(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Raw components", style = MaterialTheme.typography.headlineSmall)

        var singleSelect by remember { mutableStateOf<String?>("z") }

        RawPickerSingleSelect(
            modifier = modifier,
            label = "Single Select Picker",
            readOnly = false,
            enabled = true,
            onChange = { option -> singleSelect = option?.metaId },
            isError = false,
            optionMap = optionMap,
            selectedOption = singleSelect
        )

        var multiSelect by remember { mutableStateOf<List<String>?>(listOf("a", "z")) }

        RawPickerMultiSelect(
            modifier = modifier,
            label = "Multi Select Picker",
            readOnly = false,
            enabled = true,
            onChange = { options -> multiSelect = options?.map { it.metaId } },
            isError = false,
            optionMap = optionMap,
            selectedOptions = multiSelect
        )


        RawTextParserUi(
            text = "*bold ~strike _bold  italic strike*  only italic strike_ only strike @aditya~"
        )

        // ── RawShowCode: QR Code ──
        Text("ShowCode — QR Code", style = MaterialTheme.typography.titleSmall)
        RawShowCode(
            value = "https://neome.ai",
            codeType = EnumDefnCodeType.qrCode,
            qrSize = 150.dp
        )

        // ── RawShowCode: Bar Code ──
        Text("ShowCode — Bar Code", style = MaterialTheme.typography.titleSmall)
        RawShowCode(
            value = "1234567890",
            codeType = EnumDefnCodeType.barCode
        )

        // ── RawScanCode: Scanner Test ──
        Text("ScanCode — Scanner", style = MaterialTheme.typography.titleSmall)

        var showScanner by remember { mutableStateOf(false) }
        var scannedValue by remember { mutableStateOf<String?>(null) }

        Button(onClick = { showScanner = true }) {
            Text("Scan Code")
        }

        if (scannedValue != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Scanned: $scannedValue",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }

        if (showScanner) {
            FullScreenCameraDialog(
                onDismiss = { showScanner = false }
            ) {
                RawScanCode(
                    codeTypes = ScanCodeFormat.all,
                    onScanned = { value ->
                        scannedValue = value
                        showScanner = false
                    },
                    onDismiss = { showScanner = false }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RawShowcasePreview() {
    MaterialTheme {
        TextFieldShowcase()
    }
}

val optionMap = DefnStudioMapOfDtoOptionData(
    keys = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j"),
    map = mapOf(
        "a" to DefnDtoOptionData(
            metaId = "a",
            value = "AAAAA"
        ),
        "b" to DefnDtoOptionData(
            metaId = "b",
            value = "BBBBB"
        ),
        "c" to DefnDtoOptionData(
            metaId = "c",
            value = "CCCCC"
        ),
        "d" to DefnDtoOptionData(
            metaId = "d",
            value = "DDDDD"
        ),
        "e" to DefnDtoOptionData(
            metaId = "e",
            value = "EEEEE"
        ),
        "f" to DefnDtoOptionData(
            metaId = "f",
            value = "FFFFF"
        ),
        "g" to DefnDtoOptionData(
            metaId = "g",
            value = "GGGGG"
        ),
        "h" to DefnDtoOptionData(
            metaId = "h",
            value = "HHHHH"
        ),
        "i" to DefnDtoOptionData(
            metaId = "i",
            value = "IIIII"
        ),
        "j" to DefnDtoOptionData(
            metaId = "j",
            value = "JJJJJ"
        )
    )
)
