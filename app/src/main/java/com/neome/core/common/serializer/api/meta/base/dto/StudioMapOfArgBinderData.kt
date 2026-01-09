package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioMapOfArgBinder
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfArgBinderData(
    override val keys: Array<String>,
    override val map: Map<String, StudioBuildArgBinder>
) : StudioMapOfArgBinder
