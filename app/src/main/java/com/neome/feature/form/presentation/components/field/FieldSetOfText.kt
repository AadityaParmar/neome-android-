package com.neome.feature.form.presentation.components.field

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSetOfTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.FieldSetOfOptionIdData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.components.raw.picker.RawPickerMultiSelect
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent


/**
 * SetOfText field component for form — multi-select dropdown picker.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldSetOfTextContent for optimal recomposition.
 * Uses [RawPickerMultiSelect] for the multi-select picker UI with chips and checkboxes.
 *
 * The field value is stored as [FieldSetOfOptionIdData] containing lists of
 * selected option metaIds (valueSet) and display values (displaySet).
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration (must be DefnFieldSetOfTextData)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldSetOfText(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Cast to specific definition type to access optionMap
    val defn = defnComp as? DefnFieldSetOfTextData ?: return

    // Stable field controller remembered across recompositions
    val fieldController = rememberFieldController<FieldSetOfOptionIdData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Read reactive field value (derivedStateOf provides fine-grained recomposition)
    val fieldValue = fieldController.value.value

    // Read reactive field properties and error
    val (properties, error) = fieldController.field.value

    // Early return if field is hidden
    if (properties.hidden) return

    // Extract selected option metaIds from FieldSetOfOptionIdData
    val selectedOptionIds = fieldValue?.valueSet

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier) {
        FieldSetOfTextContent(
            optionMap = defn.optionMap,
            selectedOptions = selectedOptionIds,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            onChange = { options ->
                // Convert selected options to FieldSetOfOptionIdData or null when cleared
                val value = if (!options.isNullOrEmpty()) {
                    FieldSetOfOptionIdData(
                        valueSet = options.map { it.metaId },
                        displaySet = options.map { it.value }
                    )
                } else {
                    null
                }
                fieldController.onChange(value)
            }
        )
    }
}


/**
 * Stateless setOfText field content for optimal recomposition control.
 *
 * Wraps [RawPickerMultiSelect] with form-specific error and helper text handling.
 * Only recomposes when its parameters change.
 *
 * @param optionMap Map of available options (from DefnFieldSetOfTextData)
 * @param selectedOptions List of currently selected option metaIds (null or empty means no selection)
 * @param label Field label
 * @param placeholder Field placeholder
 * @param helperText Helper text to display below field
 * @param error Field error, if any
 * @param enabled Whether field is enabled
 * @param readOnly Whether field is read-only
 * @param onChange Callback when selection is committed (null = cleared)
 * @param modifier Modifier for customization
 */
@Composable
private fun FieldSetOfTextContent(
    optionMap: DefnStudioMapOfDtoOptionData?,
    selectedOptions: List<String>?,
    label: String?,
    placeholder: String?,
    helperText: String?,
    error: FieldError?,
    enabled: Boolean,
    readOnly: Boolean,
    onChange: (List<DefnDtoOptionData>?) -> Unit,
    modifier: Modifier = Modifier
) {
    RawPickerMultiSelect(
        optionMap = optionMap,
        selectedOptions = selectedOptions,
        onChange = onChange,
        label = label,
        placeholder = placeholder,
        helperText = error?.message ?: helperText ?: " ",
        isError = error != null,
        enabled = enabled,
        readOnly = readOnly,
        modifier = modifier
    )
}
