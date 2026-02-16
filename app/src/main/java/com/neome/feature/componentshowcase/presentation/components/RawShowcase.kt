package com.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neome.feature.form.presentation.components.raw.RawPicker

@Composable
fun RawShowcase(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Raw components", style = MaterialTheme.typography.headlineSmall)

        RawPicker(
            modifier = modifier,
            label = "Raw Picker",
            readOnly = false,
            enabled = true,
            onClear = {},
            isError = false,
            sheetContent = {},
            selectedItems = emptyList()
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
