package com.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.form.presentation.components.raw.RawPickerMultiSelect
import com.neome.feature.form.presentation.components.raw.RawPickerSingleSelect

@Composable
fun RawShowcase(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Raw components", style = MaterialTheme.typography.headlineSmall)

        var singleSelect by remember { mutableStateOf<String?>("c") }

        RawPickerSingleSelect(
            modifier = modifier,
            label = "Single Select Picker",
            readOnly = false,
            enabled = true,
            onChange = { option -> singleSelect = option?.metaId },
            isError = false,
            optionMap = DefnStudioMapOfDtoOptionData(
                keys = listOf("a", "b"),
                map = mapOf(
                    "a" to DefnDtoOptionData(
                        metaId = "a",
                        value = "A"
                    ),
                    "b" to DefnDtoOptionData(
                        metaId = "b",
                        value = "B"
                    )
                )
            ),
            selectedOption = singleSelect
        )

        var multiSelect by remember { mutableStateOf<List<String>?>(listOf("a", "b")) }

        RawPickerMultiSelect(
            modifier = modifier,
            label = "Multi Select Picker",
            readOnly = false,
            enabled = true,
            onChange = { options -> multiSelect = options?.map { it.metaId } },
            isError = false,
            optionMap = DefnStudioMapOfDtoOptionData(
                keys = listOf("a", "b"),
                map = mapOf(
                    "a" to DefnDtoOptionData(
                        metaId = "a",
                        value = "A"
                    ),
                    "b" to DefnDtoOptionData(
                        metaId = "b",
                        value = "B"
                    )
                )
            ),
            selectedOptions = multiSelect
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RawShowcasePreview() {
    MaterialTheme {
        TextFieldShowcase()
    }
}
