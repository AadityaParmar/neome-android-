package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoText
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoTextData(
    override val value: Array<String>? = null
) : DefnDtoText
