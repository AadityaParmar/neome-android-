package com.neome.feature.form.presentation.components.field

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueOptionIdData
import com.neome.feature.form.domain.ctx.LocalFormCtx
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.components.raw.picker.RawPickerSingleSelect
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent


/**
 * PickText field component for form — single-select dropdown picker.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldPickTextContent for optimal recomposition.
 * Uses [RawPickerSingleSelect] for the dropdown picker UI.
 *
 * When [DefnFieldPickTextData.optionMap] is null and [DefnFieldPickTextData.pluginApi] is present,
 * options are fetched asynchronously via [FormApiContext.onGetFieldOptions].
 * The fetch is triggered eagerly on composition.
 *
 * The field value is stored as [FieldValueOptionIdData] containing the selected
 * option's metaId and display value.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration (must be DefnFieldPickTextData)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldPickText(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Cast to specific definition type to access optionMap
    val defn = defnComp as? DefnFieldPickTextData ?: return

    // Stable field controller remembered across recompositions
    val fieldController = rememberFieldController<FieldValueOptionIdData>(
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

    // Extract selected option metaId from FieldValueOptionIdData
    val selectedOptionId = fieldValue?.optionId

    // --- Async option fetching via FormApiContext ---
    val formCtx = LocalFormCtx.current
    var fetchedOptionMap by remember { mutableStateOf<DefnStudioMapOfDtoOptionData?>(null) }
    var isFetchingOptions by remember { mutableStateOf(false) }

    LaunchedEffect(defn.optionMap, defn.pluginApi) {
        if (defn.optionMap == null && defn.pluginApi != null) {
            val apiCtx = formCtx.getApiCtx()
            if (apiCtx != null) {
                val fieldId = fieldController.fieldId as? MetaIdField ?: return@LaunchedEffect
                isFetchingOptions = true
                fetchedOptionMap = null
                apiCtx.onGetFieldOptions(fieldId) { options ->
                    fetchedOptionMap = options as? DefnStudioMapOfDtoOptionData
                    isFetchingOptions = false
                }
            }
        }
    }

    // Resolved option map: prefer static defn.optionMap, fall back to async-fetched
    val resolvedOptionMap = defn.optionMap ?: fetchedOptionMap

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier, properties = properties) {
        FieldPickTextContent(
            optionMap = resolvedOptionMap,
            selectedOption = selectedOptionId,
            isLoading = isFetchingOptions,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            onChange = { option ->
                // Convert selected option to FieldValueOptionIdData or null when cleared
                val value = if (option != null) {
                    FieldValueOptionIdData(
                        optionId = option.metaId,
                        value = option.value
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
 * Stateless pickText field content for optimal recomposition control.
 *
 * Wraps [RawPickerSingleSelect] with form-specific error and helper text handling.
 * Only recomposes when its parameters change.
 *
 * @param optionMap Map of available options (resolved from defn or async fetch)
 * @param selectedOption Currently selected option metaId (null means no selection)
 * @param isLoading Whether options are currently being fetched asynchronously
 * @param label Field label
 * @param placeholder Field placeholder
 * @param helperText Helper text to display below field
 * @param error Field error, if any
 * @param enabled Whether field is enabled
 * @param readOnly Whether field is read-only
 * @param onChange Callback when selection changes (null = cleared)
 * @param modifier Modifier for customization
 */
@Composable
private fun FieldPickTextContent(
    optionMap: DefnStudioMapOfDtoOptionData?,
    selectedOption: String?,
    isLoading: Boolean,
    label: String?,
    placeholder: String?,
    helperText: String?,
    error: FieldError?,
    enabled: Boolean,
    readOnly: Boolean,
    onChange: (DefnDtoOptionData?) -> Unit,
    modifier: Modifier = Modifier
) {
    RawPickerSingleSelect(
        optionMap = optionMap,
        selectedOption = selectedOption,
        onChange = onChange,
        isLoading = isLoading,
        label = label,
        placeholder = placeholder,
        helperText = error?.message ?: helperText,
        isError = error != null,
        enabled = enabled,
        readOnly = readOnly,
        modifier = modifier
    )
}
