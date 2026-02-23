package com.neome.feature.form.presentation.components.field

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLanguageData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickEnumData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldTimeZoneData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.components.raw.picker.RawPickerSingleSelect
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.Serializable


/**
 * Timezone data from TimeZoneKeys.json
 */
@Serializable
private data class TimeZoneEntry(
    val displayName: String
)

/**
 * Provides timezone options for FieldTimeZone.
 *
 * Loads timezones from TimeZoneKeys.json and converts them to DefnStudioMapOfDtoOptionData
 * with format: "{key} - ({utc})" for display.
 */
private object TimeZoneProvider {

    private var cachedOptionMap: DefnStudioMapOfDtoOptionData? = null

    /**
     * Get all timezones as option map.
     *
     * Each option has:
     * - metaId: timezone key (e.g., "America/New_York")
     * - value: display text (e.g., "America/New_York - (UTC-5)")
     */
    fun getOptionMap(): DefnStudioMapOfDtoOptionData {
        cachedOptionMap?.let { return it }

        val timezones = loadTimeZones()
        val optionMap = DefnStudioMapOfDtoOptionData(
            keys = timezones.keys.toList(),
            map = timezones.mapValues { (key, entry) ->
                val utcText = extractUtcText(entry.displayName)
                val displayName = if (utcText.isNotEmpty()) {
                    "$key - ($utcText)"
                } else {
                    key
                }
                DefnDtoOptionData(
                    metaId = key,
                    value = displayName
                )
            }
        )

        cachedOptionMap = optionMap
        return optionMap
    }

    /**
     * Get filtered timezones based on filterOptionSet from defn.
     *
     * @param filterOptionSet List of timezone keys to include (null = all timezones)
     */
    fun getFilteredOptionMap(filterOptionSet: List<String>?): DefnStudioMapOfDtoOptionData {
        val allTimezones = getOptionMap()

        // If no filter, return all
        if (filterOptionSet.isNullOrEmpty()) {
            return allTimezones
        }

        // Filter to only include requested timezones
        return DefnStudioMapOfDtoOptionData(
            keys = allTimezones.keys.filter { it in filterOptionSet },
            map = allTimezones.map.filterKeys { it in filterOptionSet }
        )
    }

    /**
     * Extracts UTC offset text from display name (e.g., "(UTC-5:00)" -> "UTC-5:00")
     */
    private fun extractUtcText(displayName: String): String {
        val startIndex = displayName.indexOf("(")
        val endIndex = displayName.indexOf(")")
        
        return if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            displayName.substring(startIndex + 1, endIndex)
        } else {
            ""
        }
    }

    private fun loadTimeZones(): Map<String, TimeZoneEntry> {
        return try {
            val inputStream = this::class.java.classLoader!!.getResourceAsStream("TimeZoneKeys.json")
                ?: return emptyMap()

            val jsonString = inputStream
                .bufferedReader()
                .use { it.readText() }

            JsonParser.json.decodeFromString<Map<String, TimeZoneEntry>>(jsonString)
        } catch (e: Exception) {
            emptyMap()
        }
    }
}


/**
 * TimeZone field component for form — single-select dropdown picker.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldTimeZoneContent for optimal recomposition.
 * Uses [RawPickerSingleSelect] for the dropdown picker UI.
 *
 * The field value is stored as a string (MetaIdOption) representing the selected
 * option's metaId.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldTimeZone(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Cast to specific definition type - support both DefnFieldTimeZoneData and DefnFieldPickEnumData
    val defn = defnComp as? DefnFieldTimeZoneData
        ?: defnComp as? DefnFieldPickEnumData
        ?: return

    // Get filterOptionSet if available (DefnFieldPickEnumData has it, DefnFieldTimeZoneData doesn't)
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

    // Resolve option map from TimeZoneKeys.json
    val optionMap = TimeZoneProvider.getFilteredOptionMap(filterOptionSet)

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier, properties = properties) {
        FieldTimeZoneContent(
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
 * Stateless timezone field content for optimal recomposition control.
 *
 * Wraps [RawPickerSingleSelect] with form-specific error and helper text handling.
 * Only recomposes when its parameters change.
 *
 * @param optionMap Map of available options (from TimeZoneKeys.json)
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
private fun FieldTimeZoneContent(
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
