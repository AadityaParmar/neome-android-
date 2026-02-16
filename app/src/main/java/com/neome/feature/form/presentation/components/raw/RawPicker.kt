package com.neome.feature.form.presentation.components.raw

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Raw picker component — stateless, reusable picker UI.
 *
 * Displays an [OutlinedTextField] (read-only) showing the current selection.
 * Tapping the field opens a [ModalBottomSheet] whose content is provided via [sheetContent].
 * Supports both single-select and multi-select display through the [selectedItems] list.
 *
 * State is fully controlled by the caller via [selectedItems], [onClear], and [sheetContent].
 *
 * @param selectedItems Display texts of currently selected items (empty list means no selection)
 * @param onClear Callback to clear the current selection
 * @param label Optional label for the text field
 * @param placeholder Optional placeholder shown when nothing is selected
 * @param helperText Optional supporting text displayed below the field
 * @param isError Whether to show error styling
 * @param enabled Whether the picker is interactive
 * @param readOnly Whether the picker is read-only (shows value but not interactive)
 * @param modifier Modifier for customization
 * @param sheetContent Content to display inside the bottom sheet
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RawPicker(
    selectedItems: List<String>,
    onClear: () -> Unit,
    label: String? = null,
    placeholder: String? = null,
    helperText: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier,
    sheetContent: @Composable ColumnScope.() -> Unit = {}
) {
    val isInteractive = enabled && !readOnly
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    // Display text: comma-separated selected items or empty
    val displayText = selectedItems.joinToString(", ")

    // Click detection on the text field (same pattern as FieldDate)
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    showSheet = true
                }
            }
        }
    }

    OutlinedTextField(
        value = displayText,
        onValueChange = { /* Read-only, no manual text input */ },
        label = label?.let { { Text(it) } },
        placeholder = placeholder?.let { { Text(it) } },
        supportingText = { Text(text = helperText ?: " ") },
        isError = isError,
        enabled = enabled,
        readOnly = true,
        singleLine = true,
        modifier = modifier.fillMaxWidth(),
        interactionSource = interactionSource,
        trailingIcon = {
            Row {
                if (isInteractive && selectedItems.isNotEmpty()) {
                    IconButton(onClick = onClear) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear selection"
                        )
                    }
                }
                IconButton(
                    onClick = { if (isInteractive) showSheet = true },
                    enabled = isInteractive
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Open picker"
                    )
                }
            }
        }
    )

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            sheetContent()

            // Bottom spacing for navigation bar insets
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
