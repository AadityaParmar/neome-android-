package com.neome.core.common

import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.junk.PlusJsonParser
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.junit.Before
import org.junit.Test

/**
 * Test class for JSON to Kotlin class deserialization for DefnFormSer
 * Tests DefnFieldTextSer, DefnFieldNumberSer and DefnFormSer with realistic dummy JSON
 */
class DefnFormSerTest {

    private lateinit var json: Json

    @Before
    fun setup() {
        json = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true

            // Configure serializers module for contextual types
            serializersModule = SerializersModule {}
        }
    }

    @Test
    fun `deserialize form with mixed field types`() {
        // Given - Form with both text and number fields
        val jsonString = PlusJsonParser.createSampleDefnForm()

        // When
        val form = json.decodeFromString<DefnFormData>(jsonString)
        val formStr = json.encodeToString(form)


        // Then
        println("\n=== Deserialized Form with Mixed Field Types ===")
        println("Form ID: ${form.metaId}")
        println("Form Name: ${form.name}")
        println("Form Label: ${form.label}")
        println("Component Count: ${form.compMap.size}")
        println("Form JSON: ${form.compMap}")

        form.compMap.forEach { (id, comp) ->
            println("id = ${id} comp =  ${comp}")
        }
        println("================================================\n")


    }
}


