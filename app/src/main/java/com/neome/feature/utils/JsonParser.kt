package com.neome.feature.utils

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.modules.SerializersModule

object JsonParser {
    val json: Json = Json {
        prettyPrint = true
        ignoreUnknownKeys = true
        coerceInputValues = true

        // Configure serializers module for contextual types
        serializersModule = SerializersModule {
            // this will rarely used
        }
    }

    fun isJsonString(str: String): Boolean {
        return try {
            val element = Json.parseToJsonElement(str)
            element is JsonObject || element is JsonArray
        } catch (_: Exception) {
            false
        }
    }

}

