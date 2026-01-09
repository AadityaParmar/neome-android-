package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoExcelContent
import kotlinx.serialization.Serializable


@Serializable
data class DtoExcelContentData(
    override val content: String? = null
) : DtoExcelContent
