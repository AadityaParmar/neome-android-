package com.neome.feature.form.presentation.sample

import com.neome.api.meta.base.AnyValue
import com.neome.api.meta.base.Symbol
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.utils.JsonParser
import com.neome.junk.PlusJsonParser

/**
 * Provides lightweight sample DefnForm data for demos/tests.
 */
object FormSampleDataFactory {

    fun createTextForm(): DefnFormData {
        val jsonString = PlusJsonParser.createSampleDefnForm()
        return JsonParser.json.decodeFromString<DefnFormData>(jsonString)
    }

    private fun symbol(value: String): Symbol {
        return AnyValue.create(value, Symbol::class.java)!!
    }
}
