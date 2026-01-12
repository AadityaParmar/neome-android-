package com.neome.junk

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnFieldDate
import com.neome.api.meta.base.dto.DefnFieldDecimal
import com.neome.api.meta.base.dto.DefnFieldEmail
import com.neome.api.meta.base.dto.DefnFieldLabel
import com.neome.api.meta.base.dto.DefnFieldMobileNumber
import com.neome.api.meta.base.dto.DefnFieldNumber
import com.neome.api.meta.base.dto.DefnFieldParagraph
import com.neome.api.meta.base.dto.DefnFieldPickEnum
import com.neome.api.meta.base.dto.DefnFieldSwitch
import com.neome.api.meta.base.dto.DefnFieldText
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnGrid
import com.neome.api.meta.base.dto.DefnSection
import com.neome.api.meta.base.dto.DefnTab
import java.lang.reflect.Type

/**
 * Utility object for parsing DefnForm and FormValueRaw from JSON
 */
object PlusJsonParser {

    /**
     * Custom deserializer for DefnComp that determines the concrete subclass
     * based on the "type" field in the JSON
     */
    private class DefnCompDeserializer : JsonDeserializer<DefnComp> {
        override fun deserialize(
            json: JsonElement,
            typeOfT: Type,
            context: JsonDeserializationContext
        ): DefnComp? {
            if (!json.isJsonObject) return null

            val jsonObject = json.asJsonObject
            val typeField = jsonObject.get("type")?.asString ?: return null

            // Map type string to corresponding DefnComp subclass
            val targetClass = when (typeField) {
                // Composite types
                "tab" -> DefnTab::class.java
                "section" -> DefnSection::class.java
                "grid" -> DefnGrid::class.java

                // Field types - basic
                "bool" -> DefnFieldSwitch::class.java
                "text" -> DefnFieldText::class.java
                "number" -> DefnFieldNumber::class.java
                "decimal" -> DefnFieldDecimal::class.java
                "date" -> DefnFieldDate::class.java
                "email" -> DefnFieldEmail::class.java
                "paragraph" -> DefnFieldParagraph::class.java
                "label" -> DefnFieldLabel::class.java

                // Field types - pick
                "pickText" -> DefnFieldPickEnum::class.java

                // Field types - phone/mobile
                "phone" -> DefnFieldMobileNumber::class.java
                "mobileNumber" -> DefnFieldMobileNumber::class.java

                // Add more mappings as needed based on EnumDefnCompType
                else -> {
                    Log.w(
                        "FormJsonParser",
                        "Unknown DefnComp type: $typeField, using DefnComp"
                    )
                    DefnComp::class.java
                }
            }

            return context.deserialize(json, targetClass)
        }
    }

    /**
     * Custom TypeAdapterFactory for SysId arrays
     * Handles deserialization of arrays like MetaIdField[], MetaIdComposite[], etc.
     */
    private class SysIdArrayAdapterFactory : TypeAdapterFactory {
        override fun <T : Any?> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
            val rawType = type.rawType

            // Check if this is an array type and if the component type extends SysId
            if (!rawType.isArray) return null
            val componentType = rawType.componentType ?: return null
            if (!SysId::class.java.isAssignableFrom(componentType)) return null

            @Suppress("UNCHECKED_CAST")
            return object : TypeAdapter<T>() {
                override fun write(out: JsonWriter, value: T?) {
                    if (value == null) {
                        out.nullValue()
                        return
                    }
                    out.beginArray()
                    val array = value as Array<*>
                    for (item in array) {
                        if (item is SysId) {
                            out.value(item.getId())
                        } else {
                            out.nullValue()
                        }
                    }
                    out.endArray()
                }

                override fun read(reader: JsonReader): T? {
                    if (reader.peek() == JsonToken.NULL) {
                        reader.nextNull()
                        return null
                    }

                    val list = mutableListOf<SysId>()
                    reader.beginArray()
                    while (reader.hasNext()) {
                        if (reader.peek() == JsonToken.NULL) {
                            reader.nextNull()
                        } else {
                            val id = reader.nextString()
                            val sysId = SysId.create<SysId>(id)
                            if (sysId != null) {
                                list.add(sysId)
                            }
                        }
                    }
                    reader.endArray()

                    // Create array of the correct component type
                    @Suppress("UNCHECKED_CAST")
                    val array = java.lang.reflect.Array.newInstance(
                        componentType!!,
                        list.size
                    ) as Array<SysId>
                    for (i in list.indices) {
                        array[i] = list[i]
                    }
                    return array as T
                }
            }
        }
    }

    /**
     * Create Gson instance with custom type adapters for Symbol and SysId types
     */
    private val gson: Gson by lazy {
        GsonBuilder()
            .registerTypeAdapter(DefnComp::class.java, DefnCompDeserializer())
            .registerTypeAdapterFactory(SysIdArrayAdapterFactory())
//            .registerTypeAdapter(Symbol::class.java, JsonDeserializer<Symbol> { json, _, _ ->
//                Symbol().apply { name = json.asString }
//            })
//            .registerTypeAdapter(Symbol::class.java, JsonSerializer<Symbol> { src, _, _ ->
//                JsonPrimitive(src.name)
//            })
            .registerTypeHierarchyAdapter(SysId::class.java, JsonDeserializer<SysId> { json, _, _ ->
                SysId.create<SysId>(json.asString)
            })
            .registerTypeHierarchyAdapter(SysId::class.java, JsonSerializer<SysId> { src, _, _ ->
                JsonPrimitive(src.getId())
            })
            .create()
    }

    /**
     * Parse DefnForm from JSON string
     */
    fun parseDefnForm(json: String): DefnForm? {
        return try {
            gson.fromJson(json, DefnForm::class.java)
        } catch (e: Exception) {
            Log.e("FormJsonParser", "Error parsing DefnForm JSON", e)
            null
        }
    }

    fun test() {

    }

    fun createSampleDefnForm(): String {
        return """
        {
      "metaId": "${'$'}FormSearch",
      "name": "SysFormSearch",
      "compMap": {
        "mtb-Tab": {
          "metaId": "mtb-Tab",
          "tabIdSet": [
            "msc-Details",
            "mgr-ResultGrid"
          ],
          "name": "SysFormSearch",
          "type": "tab",
          "disabled": false
        },
        "mfd-SearchText": {
          "metaId": "mfd-SearchText",
          "name": "SearchText",
          "type": "text",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        },
        "msc-Details": {
          "metaId": "msc-Details",
          "fieldIdSet": [
            "mfd-SearchText"
          ],
          "flexGrow": false,
          "name": "Details",
          "type": "section",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        },
        "mfd-SpreadsheetId": {
          "metaId": "mfd-SpreadsheetId",
          "name": "SpreadsheetId",
          "type": "spreadsheetId",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        },
        "mfd-RowId": {
          "metaId": "mfd-RowId",
          "name": "RowId",
          "type": "rowId",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        },
        "mgr-ResultGrid": {
          "metaId": "mgr-ResultGrid",
          "fieldIdSet": [
            "mfd-SpreadsheetId",
            "mfd-RowId"
          ],
          "name": "ResultGrid",
          "type": "grid",
          "permissionMatrix": {
            "keys": [],
            "map": {}
          }
        }
      },
      "displayCompositeId": "msc-Details",
      "permissionMatrix": {
        "keys": [],
        "map": {}
      },
      "layoutMap": {
        "keys": [],
        "map": {}
      },
      "visibilityRuleMap": {
        "keys": [],
        "map": {}
      },
      "formulaFieldIdSet": [],
      "gridLookupMap": {}
    }
        """.trimIndent()
    }
}
