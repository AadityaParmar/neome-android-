package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdBase
import kotlinx.serialization.Serializable


@Serializable
data class StudioValueParagraphData(
    override val argBinderMap: StudioMapOfArgBinder? = null,
    override val paramSet: Array<String>? = null,
    override val value: String
) : StudioValueParagraph
