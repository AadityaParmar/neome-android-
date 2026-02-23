package com.neome.feature.form.presentation.components.base

import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoOptionData
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioMapOfDtoOptionData

/**
 * Provides text size options for FieldPickTextSize.
 *
 * Uses EnumDefnTextSize to create option map:
 * - metaId: enum value (e.g., "body1", "h1")
 * - value: enum value in capital case (e.g., "BODY1", "H1")
 */
object TextSizeProvider {

    private var cachedOptionMap: DefnStudioMapOfDtoOptionData? = null

    /**
     * Get all text sizes as option map.
     *
     * Each option has:
     * - metaId: enum value (e.g., "body1")
     * - value: capital case (e.g., "BODY1")
     */
    fun getOptionMap(): DefnStudioMapOfDtoOptionData {
        cachedOptionMap?.let { return it }

        val textSizes = Types.EnumDefnTextSize.entries
        val optionMap = DefnStudioMapOfDtoOptionData(
            keys = textSizes.map { it.value },
            map = textSizes.associate { textSize ->
                textSize.value to DefnDtoOptionData(
                    metaId = textSize.value,
                    value = textSize.value.uppercase()
                )
            }
        )

        cachedOptionMap = optionMap
        return optionMap
    }

    /**
     * Get filtered text sizes based on filterOptionSet from defn.
     *
     * @param filterOptionSet List of text size values to include (null = all sizes)
     */
    fun getFilteredOptionMap(filterOptionSet: List<String>?): DefnStudioMapOfDtoOptionData {
        val allSizes = getOptionMap()

        // If no filter, return all
        if (filterOptionSet.isNullOrEmpty()) {
            return allSizes
        }

        // Filter to only include requested sizes
        return DefnStudioMapOfDtoOptionData(
            keys = allSizes.keys.filter { it in filterOptionSet },
            map = allSizes.map.filterKeys { it in filterOptionSet }
        )
    }
}
