package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.dto.StudioBuildDate
import com.neome.api.meta.base.dto.StudioBuildDateTime
import com.neome.core.common.serializer.sysId.AnyTimeSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildDateTimeData(
    override val customValue: String? = null,
    override val value: EnumDefnDate? = null,
    @Serializable(with = AnyTimeSer::class) override val time: Types.AnyTime? = null
) : StudioBuildDateTime
