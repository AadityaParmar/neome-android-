package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnValueCodeJavascript
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoArgData
import kotlinx.serialization.Serializable


@Serializable
data class DefnValueCodeJavascriptData(
    override val argBinderMap: Map<String, FieldDtoArgData>? = null,
    override val value: String? = null
) : DefnValueCodeJavascript
