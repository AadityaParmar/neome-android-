package com.neome.feature.form.presentation.components.raw

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.form.presentation.components.resolveThemeColor

/**
 * Raw multi-select picker component — stateless, reusable picker UI for choosing multiple options.
 *
 * Displays selected options as [InputChip]s inside an outlined text field container.
 * Chips wrap to multiple lines via [FlowRow] and each chip has a close icon for live removal.
 * Tapping the field opens a [ModalBottomSheet] with a virtualized list of options,
 * each with a checkbox on the left. A footer provides "Select All" / "Deselect All" and "Done" buttons.
 *
 * Options can be provided directly via [optionMap], or fetched asynchronously via [cbGetOptionMap].
 * If [optionMap] is null and [cbGetOptionMap] is provided, options are fetched eagerly on composition.
 * The text field shows "Loading…" until the callback delivers the options.
 *
 * Selection changes in the bottom sheet are committed only when the user presses "Done".
 * Chip removal via the close icon is live and immediately updates the parent via [onChange].
 * If no options are selected when "Done" is pressed, [onChange] receives null (same as clearing).
 *
 * State is fully controlled by the caller via [selectedOptions], [onChange], and [optionMap].
 *
 * @param optionMap Map of option metaIds to option data providing the list of choices
 * @param selectedOptions List of currently selected option metaIds (null or empty means no selection)
 * @param onChange Callback when selection is committed (receives null when selection is cleared)
 * @param cbGetOptionMap Optional async callback to fetch options when [optionMap] is null.
 *   The caller invokes the provided `cb` with the fetched options when ready.
 * @param label Optional label for the text field
 * @param placeholder Optional placeholder shown when nothing is selected
 * @param helperText Optional supporting text displayed below the field
 * @param isError Whether to show error styling
 * @param enabled Whether the picker is interactive
 * @param readOnly Whether the picker is read-only (shows value but not interactive)
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun RawPickerMultiSelect(
    optionMap: DefnStudioMapOfDtoOptionData?,
    selectedOptions: List<String>?,
    onChange: (options: List<DefnDtoOptionData>?) -> Unit,
    cbGetOptionMap: ((cb: (DefnStudioMapOfDtoOptionData?) -> Unit) -> Unit)? = null,
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

    // Async option fetching: used when optionMap is null and cbGetOptionMap is provided
    var fetchedOptionMap by remember { mutableStateOf<DefnStudioMapOfDtoOptionData?>(null) }
    var isFetchingOptions by remember { mutableStateOf(false) }

    // Eagerly fetch options on composition when optionMap is not provided
    LaunchedEffect(optionMap, cbGetOptionMap) {
        if (optionMap == null && cbGetOptionMap != null) {
            isFetchingOptions = true
            fetchedOptionMap = null
            cbGetOptionMap { options ->
                fetchedOptionMap = options
                isFetchingOptions = false
            }
        }
    }

    // Resolved option map: prefer direct optionMap, fall back to fetched
    val resolvedOptionMap = optionMap ?: fetchedOptionMap

    val hasSelection = !selectedOptions.isNullOrEmpty()

    // Detect if any selectedOption references an option that no longer exists in the map
    // Suppressed during loading so we don't flash error styling before fetch completes
    val isOptionNotFound = remember(selectedOptions, resolvedOptionMap, isFetchingOptions) {
        hasSelection && !isFetchingOptions && selectedOptions?.any { metaId ->
            resolvedOptionMap?.map?.containsKey(metaId) != true
        } == true
    }

    // Display text used to control label floating in DecorationBox
    // Non-empty when there are selections so the label stays floated
    val displayText = remember(selectedOptions, resolvedOptionMap, isFetchingOptions) {
        if (selectedOptions.isNullOrEmpty()) return@remember ""
        if (optionMap == null && isFetchingOptions) return@remember "Loading\u2026"
        selectedOptions
            .map { metaId -> resolvedOptionMap?.map?.get(metaId)?.value ?: "Not Found" }
            .joinToString(", ")
    }

    val isLoading = optionMap == null && isFetchingOptions && hasSelection
    val hasError = isError || isOptionNotFound

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

    // Helper to remove a single chip by metaId (live removal)
    fun removeChip(metaId: String) {
        val remaining = selectedOptions?.filter { it != metaId }
        if (remaining.isNullOrEmpty()) {
            onChange(null)
            focusManager.clearFocus()
        } else {
            val resultOptions = remaining.mapNotNull { id ->
                resolvedOptionMap?.map?.get(id)
            }
            onChange(resultOptions.ifEmpty { null })
        }
    }

    val colors = if (isOptionNotFound) {
        OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.error,
            focusedTextColor = MaterialTheme.colorScheme.error
        )
    } else {
        OutlinedTextFieldDefaults.colors()
    }

    BasicTextField(
        value = "",
        onValueChange = {},
        readOnly = true,
        enabled = enabled,
        textStyle = TextStyle.Default,
        cursorBrush = SolidColor(Color.Transparent),
        interactionSource = interactionSource,
        modifier = modifier.fillMaxWidth(),
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = displayText,
                innerTextField = {
                    if (isLoading) {
                        Text(
                            text = "Loading\u2026",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    } else if (hasSelection) {
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            selectedOptions?.forEach { metaId ->
                                val option = resolvedOptionMap?.map?.get(metaId)
                                val chipLabel = option?.value ?: "Not Found"
                                val isNotFound = option == null

                                InputChip(
                                    selected = true,
                                    onClick = {},
                                    label = {
                                        Text(
                                            text = chipLabel,
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    },
                                    trailingIcon = {
                                        if (isInteractive) {
                                            Icon(
                                                imageVector = Icons.Default.Close,
                                                contentDescription = "Remove $chipLabel",
                                                modifier = Modifier
                                                    .size(16.dp)
                                                    .clickable { removeChip(metaId) }
                                            )
                                        }
                                    },
                                    colors = if (isNotFound) {
                                        InputChipDefaults.inputChipColors(
                                            selectedContainerColor = MaterialTheme.colorScheme.errorContainer,
                                            selectedLabelColor = MaterialTheme.colorScheme.onErrorContainer,
                                            selectedTrailingIconColor = MaterialTheme.colorScheme.onErrorContainer
                                        )
                                    } else {
                                        InputChipDefaults.inputChipColors()
                                    }
                                )
                            }
                        }
                    } else {
                        innerTextField()
                    }
                },
                label = label?.let { { Text(it) } },
                placeholder = placeholder?.let { { Text(it) } },
                supportingText = { Text(text = helperText ?: " ") },
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
                },
                isError = hasError,
                enabled = enabled,
                singleLine = false,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                colors = colors
            )
        }
    )

    if (showSheet) {
        // Local selection state: initialized from selectedOptions when sheet opens
        val localSelectedSet = remember(showSheet) {
            mutableStateListOf(*(selectedOptions?.toTypedArray() ?: emptyArray()))
        }

        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(0.75f)
            ) {
                if (optionMap == null && isFetchingOptions) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    val optionKeys = resolvedOptionMap?.keys ?: emptyList()

                    // Search
                    var searchQuery by remember { mutableStateOf("") }
                    val filteredKeys = remember(optionKeys, searchQuery) {
                        if (searchQuery.isBlank()) optionKeys
                        else optionKeys.filter { metaId ->
                            resolvedOptionMap?.map?.get(metaId)?.value
                                ?.contains(searchQuery, ignoreCase = true) == true
                        }
                    }

                    val allFilteredSelected = filteredKeys.isNotEmpty() &&
                        filteredKeys.all { it in localSelectedSet }

                    TextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = { Text("Search options") },
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Clear search"
                                    )
                                }
                            }
                        },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        items(
                            items = filteredKeys,
                            key = { it }
                        ) { metaId ->
                            val option = resolvedOptionMap?.map?.get(metaId) ?: return@items
                            val isSelected = metaId in localSelectedSet

                            MultiSelectOptionItem(
                                option = option,
                                isSelected = isSelected,
                                onToggle = {
                                    if (isSelected) {
                                        localSelectedSet.remove(metaId)
                                    } else {
                                        localSelectedSet.add(metaId)
                                    }
                                }
                            )
                        }
                    }

                    // Footer: Select All / Deselect All + Done
                    HorizontalDivider()

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(
                            onClick = {
                                if (allFilteredSelected) {
                                    filteredKeys.forEach { localSelectedSet.remove(it) }
                                } else {
                                    filteredKeys.forEach {
                                        if (it !in localSelectedSet) localSelectedSet.add(it)
                                    }
                                }
                            }
                        ) {
                            Text(if (allFilteredSelected) "Deselect All" else "Select All")
                        }

                        TextButton(
                            onClick = {
                                val result = if (localSelectedSet.isEmpty()) {
                                    null
                                } else {
                                    localSelectedSet.mapNotNull { metaId ->
                                        resolvedOptionMap?.map?.get(metaId)
                                    }
                                }
                                onChange(result)
                                focusManager.clearFocus()
                                scope.launch {
                                    sheetState.hide()
                                }.invokeOnCompletion {
                                    showSheet = false
                                }
                            }
                        ) {
                            Text("Done")
                        }
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
 * Shows a checkbox on the left reflecting [isSelected] state. Clickable to toggle selection.
 * Text color is determined by [DefnDtoOptionData.color] if present.
 * Background becomes error container color if [DefnDtoOptionData.isRemoved] is true.
 *
 * @param option The option data to render
 * @param isSelected Whether this option is currently selected
 * @param onToggle Callback to toggle this option's selection state
 */
@Composable
private fun MultiSelectOptionItem(
    option: DefnDtoOptionData,
    isSelected: Boolean,
    onToggle: () -> Unit
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
            .clickable(onClick = onToggle)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isSelected,
            onCheckedChange = { onToggle() }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = option.value,
            style = MaterialTheme.typography.bodyLarge,
            color = textColor
        )
    }
}
