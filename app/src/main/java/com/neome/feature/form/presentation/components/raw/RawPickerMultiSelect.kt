package com.neome.feature.form.presentation.components.raw

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.form.presentation.components.resolveThemeColor

/**
 * Raw multi-select picker component — stateless, reusable picker UI for choosing multiple options.
 *
 * Displays an [OutlinedTextField] (read-only) showing comma-separated selected options.
 * Tapping the field opens a [ModalBottomSheet] with a virtualized list of options.
 * Each option has a checkbox on the left reflecting the current selection state.
 *
 * State is fully controlled by the caller via [selectedOptions], [onClear], and [optionMap].
 *
 * @param optionMap Map of option metaIds to option data providing the list of choices
 * @param selectedOptions List of currently selected option metaIds (null or empty means no selection)
 * @param onClear Callback to clear the current selection
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
fun RawPickerMultiSelect(
    optionMap: DefnStudioMapOfDtoOptionData?,
    selectedOptions: List<String>?,
    onClear: () -> Unit,
    label: String? = null,
    placeholder: String? = null,
    helperText: String? = null,
    isError: Boolean = false,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    modifier: Modifier = Modifier
) {
    val isInteractive = enabled && !readOnly
    var showSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val selectedSet = remember(selectedOptions) {
        selectedOptions?.toSet() ?: emptySet()
    }

    // Display text: comma-separated display values of selected options
    val displayText = remember(selectedOptions, optionMap) {
        selectedOptions
            ?.mapNotNull { metaId -> optionMap?.map?.get(metaId)?.value }
            ?.joinToString(", ")
            ?: ""
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
        isError = isError,
        enabled = enabled,
        readOnly = true,
        singleLine = true,
        modifier = modifier.fillMaxWidth(),
        interactionSource = interactionSource,
        trailingIcon = {
            Row {
                if (isInteractive && selectedSet.isNotEmpty()) {
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
                        val isSelected = metaId in selectedSet

                        MultiSelectOptionItem(
                            option = option,
                            isSelected = isSelected
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
 * A single option item for the multi-select picker list.
 *
 * Shows a checkbox on the left reflecting [isSelected] state.
 * Text color is determined by [DefnDtoOptionData.color] if present.
 * Background becomes error container color if [DefnDtoOptionData.isRemoved] is true.
 *
 * @param option The option data to render
 * @param isSelected Whether this option is currently selected
 */
@Composable
private fun MultiSelectOptionItem(
    option: DefnDtoOptionData,
    isSelected: Boolean
) {
    val isRemoved = option.isRemoved == true

    val backgroundColor = if (isRemoved) {
        MaterialTheme.colorScheme.errorContainer
    } else {
        Color.Transparent
    }

    val textColor = resolveThemeColor(option.color)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isSelected,
            onCheckedChange = null // onClick handled later
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = option.value,
            style = MaterialTheme.typography.bodyLarge,
            color = textColor
        )
    }
}
