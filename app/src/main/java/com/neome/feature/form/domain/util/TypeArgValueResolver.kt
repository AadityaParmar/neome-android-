package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.Types.EnumDefnTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class TypeCustomValueDate(
    val id: String,
    val kind: String,
    val name: String,
    val value: EnumDefnDate? = null,
    val customDate: String? = null  // ISO date string
)

@Serializable
data class TypeCustomValueTime(
    val id: String,
    val kind: String,
    val name: String,
    val customValue: String? = null,  // "23:59:00" format
    val value: EnumDefnTime? = null
)

@Serializable
data class TypeCustomValueDateTime(
    val id: String,
    val kind: String,
    val name: String,
    val value: EnumDefnDate? = null,
    val customDate: String? = null,  // ISO date string
    val customTime: String? = null   // "23:59:00" format
)

@Serializable
data class TypeCustomValueSeq(
    val id: String,
    val kind: String,
    val name: String
)

/**
 * Client-side wrapper for arg values parsed from DefnDtoText.value strings.
 * The argValue and customValueMap are JsonElement because they're polymorphic -
 * decoded manually based on 'kind' field using existing *Data.serializer() classes.
 */
@Serializable
data class StudioDtoArgValueForClient(
    val kind: EnumDefnArgBinder,
    val argValue: JsonElement,              // Polymorphic - decode per kind
    val customValueMap: JsonElement? = null // Polymorphic - decode per customValueMap.kind
)
