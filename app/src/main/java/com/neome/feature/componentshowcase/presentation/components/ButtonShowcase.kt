package com.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonShowcase(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Buttons", style = MaterialTheme.typography.headlineSmall)

        // Filled Button
        Button(onClick = {}) {
            Text("Filled Button")
        }

        // Filled Tonal Button
        FilledTonalButton(onClick = {}) {
            Text("Filled Tonal Button")
        }

        // Outlined Button
        OutlinedButton(onClick = {}) {
            Text("Outlined Button")
        }

        // Elevated Button
        ElevatedButton(onClick = {}) {
            Text("Elevated Button")
        }

        // Text Button
        TextButton(onClick = {}) {
            Text("Text Button")
        }

        // Button with Icon
        Button(
            onClick = {},
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Button with Icon")
        }

        // Disabled Button
        Button(onClick = {}, enabled = false) {
            Text("Disabled Button")
        }

        HorizontalDivider()

        Text("Icon Buttons", style = MaterialTheme.typography.headlineSmall)

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Icon Button
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }

            // Filled Icon Button
            FilledIconButton(onClick = {}) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }

            // Filled Tonal Icon Button
            FilledTonalIconButton(onClick = {}) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }

            // Outlined Icon Button
            OutlinedIconButton(onClick = {}) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favorite")
            }
        }

        HorizontalDivider()

        Text("Floating Action Buttons", style = MaterialTheme.typography.headlineSmall)

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Small FAB
            SmallFloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }

            // Regular FAB
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }

            // Large FAB
            LargeFloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }

            // Extended FAB
            ExtendedFloatingActionButton(
                onClick = {},
                icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                text = { Text("Extended FAB") }
            )
        }

        HorizontalDivider()

        Text("Segmented Button", style = MaterialTheme.typography.headlineSmall)

        var selectedIndex by remember { mutableStateOf(0) }
        val options = listOf("Day", "Month", "Year")

        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size)
                ) {
                    Text(label)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonShowcasePreview() {
    MaterialTheme {
        ButtonShowcase()
    }
}
