package com.neome.core.common

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.MetaIdCompSer
import com.neome.core.common.serializer.MetaIdCompositeSer
import com.neome.core.common.serializer.MetaIdFieldSer
import com.neome.core.common.serializer.MetaIdFormSer
import com.neome.core.common.serializer.MetaIdGridSer
import com.neome.core.common.serializer.MetaIdLayoutGridSer
import com.neome.core.common.serializer.MetaIdRoleSer
import com.neome.core.common.serializer.SymbolSer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.junit.Assert
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
            serializersModule = SerializersModule {
                // Register custom serializers for MetaId types
                contextual(Types.MetaIdField::class, MetaIdFieldSer)
                contextual(Types.MetaIdComp::class, MetaIdCompSer)
                contextual(Types.MetaIdForm::class, MetaIdFormSer)
                contextual(Types.MetaIdRole::class, MetaIdRoleSer)
                contextual(Types.MetaIdComposite::class, MetaIdCompositeSer)
                contextual(Types.MetaIdLayoutGrid::class, MetaIdLayoutGridSer)
                contextual(Types.MetaIdGrid::class, MetaIdGridSer)

                // Symbol and DefnDtoText serializers
                contextual(Symbol::class, SymbolSer)
//                contextual(DefnDtoText::class, DefnDtoTextSer)

                // Note: DefnComp polymorphism is handled by DefnCompSerializer
                // which inspects the type field
            }
        }
    }

    @Test
    fun `deserialize form with mixed field types`() {
        // Given - Form with both text and number fields
        val jsonString = """
        {
          "metaId": "mf-form003",
          "name": "registrationForm",
          "displayCompositeId": "mtb-composite003",
          "label": "User Registration",
          "compMap": {
            "mfd-field003": {
              "type": "text",
              "name": "username",
              "metaId": "mfd-field003",
              "label": "Username",
              "required": true,
              "minCharCount": 3,
              "maxCharCount": 20,
              "placeHolder": "Enter username",
              "helperTextVar": {
                "value": ["Please enter", "a unique username"]
              },
              "prefixVar": {
                "value": ["@"]
              }
            },
            "mfd-field004": {
              "type": "text",
              "name": "email",
              "metaId": "mfd-field004",
              "label": "Email",
              "required": true,
              "placeHolder": "you@example.com",
              "defaultVar": {
                "value": ["user", "@example.com"]
              },
              "suffixVar": {
                "value": [".com", ".org"]
              }
            },
            "mfd-field005": {
              "type": "number",
              "name": "experienceYears",
              "metaId": "mfd-field005",
              "label": "Years of Experience",
              "min": 0,
              "max": 50,
              "defaultValue": 0
            }
          }
        }
        """.trimIndent()

        // When
        val form = json.decodeFromString<DefnFormSer>(jsonString)
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

        Assert.assertNotNull(form)
        Assert.assertEquals("registrationForm", form.name.toString())
        Assert.assertEquals("User Registration", form.label)
        Assert.assertEquals(3, form.compMap.size)

        // Verify text fields
        val textFields = form.compMap.values.filterIsInstance<DefnFieldTextSer>()
        Assert.assertEquals(2, textFields.size)

        val usernameField = textFields.find { it.name.toString() == "username" }
        Assert.assertNotNull(usernameField)
        Assert.assertEquals(3, usernameField?.minCharCount)
        Assert.assertEquals(20, usernameField?.maxCharCount)
        Assert.assertEquals("Enter username", usernameField?.placeHolder)
        Assert.assertNotNull(usernameField?.helperTextVar)
        Assert.assertArrayEquals(
            arrayOf("Please enter", "a unique username"),
            usernameField?.helperTextVar?.value
        )
        Assert.assertNotNull(usernameField?.prefixVar)
        Assert.assertArrayEquals(arrayOf("@"), usernameField?.prefixVar?.value)

        val emailField = textFields.find { it.name.toString() == "email" }
        Assert.assertNotNull(emailField)
        Assert.assertNotNull(emailField?.defaultVar)
        Assert.assertArrayEquals(arrayOf("user", "@example.com"), emailField?.defaultVar?.value)
        Assert.assertNotNull(emailField?.suffixVar)
        Assert.assertArrayEquals(arrayOf(".com", ".org"), emailField?.suffixVar?.value)

        // Verify number fields
        val numberFields = form.compMap.values.filterIsInstance<DefnFieldNumberSer>()
        Assert.assertEquals(1, numberFields.size)

        val experienceField = numberFields.first()
        Assert.assertEquals("experienceYears", experienceField.name.toString())
        Assert.assertEquals(0, experienceField.min)
        Assert.assertEquals(50, experienceField.max)
        Assert.assertEquals(0, experienceField.defaultValue)
    }
}
