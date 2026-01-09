package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnTime
import com.neome.api.meta.base.dto.StudioBuildTime
import com.neome.core.common.serializer.sysId.AnyTimeSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildTimeData(
    @Serializable(with = AnyTimeSer::class) override val customValue: Types.AnyTime? = null,
    override val value: EnumDefnTime? = null
) : StudioBuildTime
