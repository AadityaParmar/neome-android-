package com.neome.feature.form.presentation.components.field

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLineStrokeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickEnumData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.components.raw.picker.RawPickerSingleSelect
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent


/**
 * Provides line stroke options for FieldPickLineStroke.
 *
 * Uses EnumDefnThemeStroke to create option map:
 * - metaId: enum value (e.g., "dash", "dotted", "solid")
 * - value: label case (e.g., "Dash", "Dotted", "Solid")
 */
private object LineStrokeProvider {

    private var cachedOptionMap: DefnStudioMapOfDtoOptionData? = null

    /**
     * Get all line strokes as option map.
     *
     * Each option has:
     * - metaId: enum value (e.g., "dash")
     * - value: label case (e.g., "Dash")
     */
    fun getOptionMap(): DefnStudioMapOfDtoOptionData {
        cachedOptionMap?.let { return it }

        val lineStrokes = Types.EnumDefnThemeStroke.entries
        val optionMap = DefnStudioMapOfDtoOptionData(
            keys = lineStrokes.map { it.value },
            map = lineStrokes.associate { stroke ->
                stroke.value to DefnDtoOptionData(
                    metaId = stroke.value,
                    value = stroke.value.replaceFirstChar { it.titlecase() }
                )
            }
        )

        cachedOptionMap = optionMap
        return optionMap
    }

    /**
     * Get filtered line strokes based on filterOptionSet from defn.
     *
     * @param filterOptionSet List of line stroke values to include (null = all strokes)
     */
    fun getFilteredOptionMap(filterOptionSet: List<String>?): DefnStudioMapOfDtoOptionData {
        val allStrokes = getOptionMap()

        // If no filter, return all
        if (filterOptionSet.isNullOrEmpty()) {
            return allStrokes
        }

        // Filter to only include requested strokes
        return DefnStudioMapOfDtoOptionData(
            keys = allStrokes.keys.filter { it in filterOptionSet },
            map = allStrokes.map.filterKeys { it in filterOptionSet }
        )
    }
}


/**
 * PickLineStroke field component for form — single-select dropdown picker.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldPickLineStrokeContent for optimal recomposition.
 * Uses [RawPickerSingleSelect] for the dropdown picker UI.
 *
 * The field value is stored as a string (MetaIdOption) representing the selected
 * option's metaId.
 *
 * Uses EnumDefnThemeStroke for options:
 * - metaId: enum value (e.g., "dash", "dotted", "solid")
 * - value: label case (e.g., "Dash", "Dotted", "Solid")
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldPickLineStroke(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Cast to specific definition type - support both DefnFieldLineStrokeData and DefnFieldPickEnumData
    val defn = defnComp as? DefnFieldLineStrokeData
        ?: defnComp as? DefnFieldPickEnumData
        ?: return

    // Get filterOptionSet if available (DefnFieldPickEnumData has it, DefnFieldLineStrokeData doesn't)
    val filterOptionSet = (defn as? DefnFieldPickEnumData)?.filterOptionSet

    // Stable field controller remembered across recompositions
    // Using String as field value type (MetaIdOption)
    val fieldController = rememberFieldController<String>(
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

    // Extract selected option metaId (field value is directly the option ID string)
    val selectedOptionId = fieldValue

    // Resolve option map from EnumDefnThemeStroke
    val optionMap = LineStrokeProvider.getFilteredOptionMap(filterOptionSet)

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier, properties = properties) {
        FieldPickLineStrokeContent(
            optionMap = optionMap,
            selectedOption = selectedOptionId,
            isLoading = false,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            onChange = { option ->
                // Convert selected option to string (option ID) or null when cleared
                val value = option?.metaId
                fieldController.onChange(value)
            }
        )
    }
}


/**
 * Stateless pickLineStroke field content for optimal recomposition control.
 *
 * Wraps [RawPickerSingleSelect] with form-specific error and helper text handling.
 * Only recomposes when its parameters change.
 *
 * @param optionMap Map of available options (from EnumDefnThemeStroke)
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
private fun FieldPickLineStrokeContent(
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
