package com.neome.feature.form.presentation.components.raw

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.form.presentation.components.resolveThemeColor

/**
 * Raw single-select picker component — stateless, reusable picker UI for choosing one option.
 *
 * Displays an [OutlinedTextField] (read-only) showing the currently selected option.
 * Tapping the field opens a [ModalBottomSheet] with a virtualized list of options.
 * Each option is a plain text row (no checkbox).
 *
 * State is fully controlled by the caller via [selectedOption], [onClear], and [optionMap].
 *
 * @param optionMap Map of option metaIds to option data providing the list of choices
 * @param selectedOption Currently selected option metaId (null means no selection)
 * @param onChange Callback when user selects an option (receives null when selection is cleared)
 * @param label Optional label for the text field
 * @param placeholder Optional placeholder shown when nothing is selected
 * @param helperText Optional supporting text displayed below the field
 * @param isError Whether to show error styling
 * @param enabled Whether the picker is interactive
 * @param readOnly Whether the picker is read-only (shows value but not interactive)
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RawPickerSingleSelect(
    optionMap: DefnStudioMapOfDtoOptionData?,
    selectedOption: String?,
    onChange: (option: DefnDtoOptionData?) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    helperText: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
) {
    val isInteractive = enabled && !readOnly
    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val hasSelection = !selectedOption.isNullOrEmpty()

    // Detect if selectedOption references an option that no longer exists in the map
    val isOptionNotFound = remember(selectedOption, optionMap) {
        hasSelection && optionMap?.map?.containsKey(selectedOption) != true
    }

    // Display text: the display value of the selected option, or "Not Found" if missing
    val displayText = remember(selectedOption, optionMap) {
        if (selectedOption.isNullOrEmpty()) return@remember ""
        optionMap?.map?.get(selectedOption)?.value ?: "Not Found"
    }

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
        isError = isError || isOptionNotFound,
        enabled = enabled,
        readOnly = true,
        singleLine = true,
        colors = if (isOptionNotFound) {
            OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = MaterialTheme.colorScheme.error,
                focusedTextColor = MaterialTheme.colorScheme.error
            )
        } else {
            OutlinedTextFieldDefaults.colors()
        },
        modifier = modifier.fillMaxWidth(),
        interactionSource = interactionSource,
        trailingIcon = {
            Row {
                if (isInteractive && hasSelection) {
                    IconButton(onClick = {
                        onChange(null)
                        focusManager.clearFocus()
                    }) {
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
        val optionKeys = optionMap?.keys ?: emptyList()

        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(0.75f)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    items(
                        items = optionKeys,
                        key = { it }
                    ) { metaId ->
                        val option = optionMap?.map?.get(metaId) ?: return@items
                        val isSelected = metaId == selectedOption

                        SingleSelectOptionItem(
                            option = option,
                            isSelected = isSelected,
                            onClick = {
                                onChange(option)
                                scope.launch {
                                    sheetState.hide()
                                }.invokeOnCompletion {
                                    showSheet = false
                                }
                            }
                        )
                    }
                }

                // Bottom spacing for navigation bar insets
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

/**
 * A single option item for the single-select picker list.
 *
 * Plain text row without checkbox. Clickable to trigger selection.
 * Text color is determined by [DefnDtoOptionData.color] if present.
 * Background becomes error container color if [DefnDtoOptionData.isRemoved] is true,
 * or primary container color if [isSelected] is true.
 *
 * @param option The option data to render
 * @param isSelected Whether this option is currently selected
 * @param onClick Callback when the option is tapped
 */
@Composable
private fun SingleSelectOptionItem(
    option: DefnDtoOptionData,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val isRemoved = option.isRemoved == true

    val backgroundColor = when {
        isRemoved -> MaterialTheme.colorScheme.errorContainer
        isSelected -> MaterialTheme.colorScheme.primaryContainer
        else -> Color.Transparent
    }

    val textColor = resolveThemeColor(option.color)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = option.value,
            style = MaterialTheme.typography.bodyLarge,
            color = textColor
        )
    }
}
