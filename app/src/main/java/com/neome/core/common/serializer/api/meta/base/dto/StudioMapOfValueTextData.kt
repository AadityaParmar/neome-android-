package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfValueText
import com.neome.api.meta.base.dto.StudioValueText
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueTextData
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfValueTextData(
    override val keys: List<String>,
    override val map: Map<String, StudioValueTextData>
) : StudioMapOfValueText
