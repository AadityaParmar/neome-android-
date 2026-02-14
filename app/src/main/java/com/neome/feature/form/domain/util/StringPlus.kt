package com.neome.feature.form.domain.util

import kotlinx.serialization.json.Json

/**
 * String utility functions for form resolution.
 */
object StringPlus {

    /**
     * Returns true if the given string is valid JSON.
     *
     * Port of: webapp/src/base/plus/StringPlus.ts > isJsonString
     */
    fun isJsonString(str: String): Boolean {
        return try {
            Json.parseToJsonElement(str)
            true
        } catch (_: Exception) {
            false
        }
    }
}
