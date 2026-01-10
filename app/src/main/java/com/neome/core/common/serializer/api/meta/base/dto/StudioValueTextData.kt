package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.api.meta.base.dto.StudioValueText
import com.neome.api.meta.base.dto.StudioValueVarIdBase
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfArgBinderData
import kotlinx.serialization.Serializable


@Serializable
data class StudioValueTextData(
    override val argBinderMap: StudioMapOfArgBinderData? = null,
    override val paramSet: List<String>? = null,
    override val value: String
) : StudioValueText
