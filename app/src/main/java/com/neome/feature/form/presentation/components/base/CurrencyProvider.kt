package com.neome.feature.form.presentation.components.base

import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.Serializable

/**
 * Currency data from Currencies.json
 */
@Serializable
data class CurrencyData(
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
object CurrencyProvider {

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
