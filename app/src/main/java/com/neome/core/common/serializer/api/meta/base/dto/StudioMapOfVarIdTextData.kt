package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfVarIdText
import com.neome.api.meta.base.dto.StudioValueVarIdText
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueVarIdTextData
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfVarIdTextData(
    override val keys: List<String>,
    override val map: Map<String, StudioValueVarIdTextData>
) : StudioMapOfVarIdText
