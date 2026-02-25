package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldSetOfStringData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * ChipSet field component for form.
 *
 * Renders an editable text input where pressing Enter/Done creates a chip from the typed text.
 * Created chips are displayed as [InputChip]s inside the field using [FlowRow], each with a
 * close icon for individual removal. A trailing clear icon resets the entire field value to null.
 *
 * The field height adjusts automatically to fit all chips as they wrap to multiple lines.
 *
 * Uses [FieldSetOfStringData] as its value type. The [FieldSetOfStringData.valueSet] list
 * maintains proper indexing — new chips are appended, and removals produce a re-indexed list
 * without gaps.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldChipSetContent for optimal recomposition.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration (DefnFieldChipSetData)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldChipSet(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Stable field controller remembered across recompositions
    val fieldController = rememberFieldController<FieldSetOfStringData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Read reactive field value (derivedStateOf provides fine-grained recomposition)
    val fieldValue = fieldController.value.value

    // Read reactive field properties and error
    val (properties, error) = fieldController.field.value

    // Current list of chip strings
    val chipValues = fieldValue?.valueSet ?: emptyList()

    // Early return if field is hidden
    if (properties.hidden) return

    val isInteractive = !properties.disabled && !properties.readOnly

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier, properties = properties) {
        FieldChipSetContent(
            chipValues = chipValues,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            isInteractive = isInteractive,
            onChipAdd = { newChip ->
                // Append new chip to existing list
                val updatedList = chipValues + newChip
                fieldController.onChange(FieldSetOfStringData(valueSet = updatedList))
            },
            onChipRemove = { index ->
                // Remove chip at index; list re-indexes automatically
                val updatedList = chipValues.filterIndexed { i, _ -> i != index }
                if (updatedList.isEmpty()) {
                    fieldController.onChange(null)
                } else {
                    fieldController.onChange(FieldSetOfStringData(valueSet = updatedList))
                }
            },
            onClearAll = {
                fieldController.onChange(null)
            }
        )
    }
}

/**
 * Stateless chip set field content for optimal recomposition control.
 *
 * Uses [BasicTextField] with [OutlinedTextFieldDefaults.DecorationBox] to render an outlined
 * text field container that holds both chips ([FlowRow] of [InputChip]) and a text input.
 * Pressing Enter/Done on the keyboard creates a new chip from the current input text.
 * Each chip has a close icon for individual removal. A trailing clear icon resets the field.
 *
 * The field expands vertically ([singleLine] = false) to accommodate wrapping chips.
 *
 * Layout:
 * ```
 * ┌──────────────────────────────────────────────────────────┐
 * │ [Chip 1 ✕] [Chip 2 ✕] [Chip 3 ✕]                       │
 * │ [Chip 4 ✕] [text input____]                    | ✕ icon │
 * └──────────────────────────────────────────────────────────┘
 * helper text || error text
 * ```
 *
 * @param chipValues Current list of chip string values
 * @param label Field label
 * @param placeholder Field placeholder (shown when no chips and no input text)
 * @param helperText Helper text to display below field
 * @param error Field error, if any
 * @param enabled Whether field is enabled
 * @param readOnly Whether field is read-only
 * @param isInteractive Whether chips can be added/removed (enabled && !readOnly)
 * @param onChipAdd Callback when a new chip should be created from input text
 * @param onChipRemove Callback when a chip at a given index should be removed
 * @param onClearAll Callback when clear icon is clicked to reset the entire field
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FieldChipSetContent(
    chipValues: List<String>,
    label: String?,
    placeholder: String?,
    helperText: String?,
    error: FieldError?,
    enabled: Boolean,
    readOnly: Boolean,
    isInteractive: Boolean,
    onChipAdd: (String) -> Unit,
    onChipRemove: (Int) -> Unit,
    onClearAll: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Local text input state for the chip being typed
    var inputText by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    val hasChips = chipValues.isNotEmpty()
    val hasContent = hasChips || inputText.isNotEmpty()

    // Display text used to control label floating in DecorationBox
    // Non-empty when there are chips or input text so the label stays floated
    val displayText = if (hasContent) " " else ""

    BasicTextField(
        value = inputText,
        onValueChange = { inputText = it },
        enabled = enabled,
        readOnly = readOnly,
        textStyle = TextStyle.Default.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                val trimmed = inputText.trim()
                if (trimmed.isNotEmpty() && isInteractive) {
                    onChipAdd(trimmed)
                    inputText = ""
                }
            }
        ),
        modifier = modifier.fillMaxWidth(),
        decorationBox = { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = displayText,
                innerTextField = {
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        // Render existing chips
                        chipValues.forEachIndexed { index, chipText ->
                            InputChip(
                                selected = true,
                                onClick = {},
                                label = {
                                    Text(
                                        text = chipText,
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                },
                                trailingIcon = {
                                    if (isInteractive) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Remove $chipText",
                                            modifier = Modifier
                                                .size(16.dp)
                                                .clickable { onChipRemove(index) }
                                        )
                                    }
                                },
                                colors = InputChipDefaults.inputChipColors()
                            )
                        }

                        // Inline text input after chips
                        if (isInteractive) {
                            innerTextField()
                        }
                    }
                },
                label = label?.let { { Text(it) } },
                placeholder = if (!hasChips) placeholder?.let { { Text(it) } } else null,
                supportingText = error?.message?.let { { Text(it) } }
                    ?: helperText?.let { { Text(it) } },
                trailingIcon = {
                    if (isInteractive && hasChips) {
                        IconButton(onClick = {
                            onClearAll()
                            inputText = ""
                            focusManager.clearFocus()
                        }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear all"
                            )
                        }
                    }
                },
                isError = error != null,
                enabled = enabled,
                singleLine = false,
                visualTransformation = VisualTransformation.None,
                interactionSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() },
                colors = OutlinedTextFieldDefaults.colors()
            )
        }
    )
}
