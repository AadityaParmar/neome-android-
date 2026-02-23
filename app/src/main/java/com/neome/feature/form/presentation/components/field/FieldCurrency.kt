package com.neome.feature.form.presentation.components.field

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldCurrencyData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickEnumData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldPickOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.components.raw.picker.RawPickerSingleSelect
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.Serializable


/**
 * Currency data from Currencies.json
 */
@Serializable
private data class CurrencyData(
    val code: String,
    val name: String,
    val name_plural: String? = null,
    val symbol: String? = null,
    val symbol_native: String? = null,
    val decimal_digits: Int? = null,
    val rounding: Int? = null
)

/**
 * Provides currency options for FieldCurrency.
 *
 * Loads currencies from Currencies.json and converts them to DefnStudioMapOfDtoOptionData
 * with format: "{code} - {name}" for display.
 */
private object CurrencyProvider {

    private var cachedOptionMap: DefnStudioMapOfDtoOptionData? = null

    /**
     * Get all currencies as option map.
     *
     * Each option has:
     * - metaId: currency code (e.g., "USD")
     * - value: display text (e.g., "USD - US Dollar")
     */
    fun getOptionMap(): DefnStudioMapOfDtoOptionData {
        cachedOptionMap?.let { return it }

        val currencies = loadCurrencies()
        val optionMap = DefnStudioMapOfDtoOptionData(
            keys = currencies.map { currency -> currency.code },
            map = currencies.associate { currency ->
                currency.code to DefnDtoOptionData(
                    metaId = currency.code,
                    value = "${currency.code} - ${currency.name}"
                )
            }
        )

        cachedOptionMap = optionMap
        return optionMap
    }

    /**
     * Get filtered currencies based on filterOptionSet from defn.
     *
     * @param filterOptionSet List of currency codes to include (null = all currencies)
     */
    fun getFilteredOptionMap(filterOptionSet: List<String>?): DefnStudioMapOfDtoOptionData {
        val allCurrencies = getOptionMap()

        // If no filter, return all
        if (filterOptionSet.isNullOrEmpty()) {
            return allCurrencies
        }

        // Filter to only include requested currencies
        return DefnStudioMapOfDtoOptionData(
            keys = allCurrencies.keys.filter { it in filterOptionSet },
            map = allCurrencies.map.filterKeys { it in filterOptionSet }
        )
    }

    private fun loadCurrencies(): List<CurrencyData> {
        return try {
            val inputStream = this::class.java.classLoader!!.getResourceAsStream("Currencies.json")
                ?: return emptyList()

            val jsonString = inputStream
                .bufferedReader()
                .use { it.readText() }

            JsonParser.json.decodeFromString<List<CurrencyData>>(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }
}


/**
 * Currency field component for form — single-select dropdown picker.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldCurrencyContent for optimal recomposition.
 * Uses [RawPickerSingleSelect] for the dropdown picker UI.
 *
 * The field value is stored as a string (MetaIdOption) representing the selected
 * option's metaId.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration (must be DefnFieldPickEnumData)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldCurrency(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Cast to specific definition type - support multiple types that can be used for currency
    val defn = defnComp as? DefnFieldPickEnumData
        ?: defnComp as? DefnFieldCurrencyData
        ?: defnComp as? DefnFieldPickOptionData
        ?: return

    // Get filter/option set from the appropriate type
    val filterOptionSet = when (defn) {
        is DefnFieldPickEnumData -> defn.filterOptionSet
        is DefnFieldPickOptionData -> defn.optionSet
        is DefnFieldCurrencyData -> null // DefnFieldCurrency doesn't have filterOptionSet
        else -> null
    }

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

    // Resolve option map from Currencies.json
    // If filterOptionSet is provided, only include those currencies
    val optionMap = CurrencyProvider.getFilteredOptionMap(filterOptionSet)

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier, properties = properties) {
        FieldCurrencyContent(
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
 * Stateless currency field content for optimal recomposition control.
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
private fun FieldCurrencyContent(
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
