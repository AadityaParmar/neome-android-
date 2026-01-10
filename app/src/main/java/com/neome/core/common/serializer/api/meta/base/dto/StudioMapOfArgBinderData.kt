package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfArgBinderData(
    override val keys: List<String>,
    override val map: Map<String, StudioBuildArgBinderData>
) : StudioMapOfArgBinder
