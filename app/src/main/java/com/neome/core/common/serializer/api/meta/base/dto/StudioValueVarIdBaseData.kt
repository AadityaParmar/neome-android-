package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.api.meta.base.dto.StudioValueVarIdBase
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfArgBinderData
import kotlinx.serialization.Serializable


@Serializable
data class StudioValueVarIdBaseData(
    override val argBinderMap: StudioMapOfArgBinderData? = null
) : StudioValueVarIdBase
