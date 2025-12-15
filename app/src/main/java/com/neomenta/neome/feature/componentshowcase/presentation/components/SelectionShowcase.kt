package com.neomenta.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SelectionShowcase(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Selection Controls", style = MaterialTheme.typography.headlineSmall)

        Divider()
        Text("Checkboxes", style = MaterialTheme.typography.titleMedium)

        var checked1 by remember { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = checked1,
                onCheckedChange = { checked1 = it }
            )
            Text("Checkbox")
        }

        var checked2 by remember { mutableStateOf(true) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = checked2,
                onCheckedChange = { checked2 = it }
            )
            Text("Checked by default")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {},
                enabled = false
            )
            Text("Disabled Checkbox")
        }

        var triState by remember { mutableStateOf(ToggleableState.Indeterminate) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TriStateCheckbox(
                state = triState,
                onClick = {
                    triState = when (triState) {
                        ToggleableState.On -> ToggleableState.Off
                        ToggleableState.Off -> ToggleableState.Indeterminate
                        ToggleableState.Indeterminate -> ToggleableState.On
                    }
                }
            )
            Text("Tri-state Checkbox (${triState.name})")
        }

        Divider()
        Text("Radio Buttons", style = MaterialTheme.typography.titleMedium)

        val radioOptions = listOf("Option 1", "Option 2", "Option 3")
        var selectedOption by remember { mutableStateOf(radioOptions[0]) }

        radioOptions.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = { selectedOption = option }
                )
                Text(option)
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            RadioButton(
                selected = false,
                onClick = {},
                enabled = false
            )
            Text("Disabled Radio Button")
        }

        Divider()
        Text("Switches", style = MaterialTheme.typography.titleMedium)

        var switch1 by remember { mutableStateOf(false) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Switch")
            Switch(
                checked = switch1,
                onCheckedChange = { switch1 = it }
            )
        }

        var switch2 by remember { mutableStateOf(true) }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Checked Switch")
            Switch(
                checked = switch2,
                onCheckedChange = { switch2 = it }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Disabled Switch")
            Switch(
                checked = false,
                onCheckedChange = {},
                enabled = false
            )
        }

        Divider()
        Text("Sliders", style = MaterialTheme.typography.titleMedium)

        var sliderValue by remember { mutableFloatStateOf(0.5f) }
        Column {
            Text("Slider value: ${(sliderValue * 100).toInt()}%")
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                modifier = Modifier.fillMaxWidth()
            )
        }

        var rangeSliderValue by remember { mutableStateOf(0.2f..0.8f) }
        Column {
            Text("Range: ${(rangeSliderValue.start * 100).toInt()}% - ${(rangeSliderValue.endInclusive * 100).toInt()}%")
            RangeSlider(
                value = rangeSliderValue,
                onValueChange = { rangeSliderValue = it },
                modifier = Modifier.fillMaxWidth()
            )
        }

        var stepsSlider by remember { mutableFloatStateOf(0f) }
        Column {
            Text("Steps Slider: ${stepsSlider.toInt()}")
            Slider(
                value = stepsSlider,
                onValueChange = { stepsSlider = it },
                valueRange = 0f..10f,
                steps = 9,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectionShowcasePreview() {
    MaterialTheme {
        SelectionShowcase()
    }
}
