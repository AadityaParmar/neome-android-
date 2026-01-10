package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.Types.EnumDefnLocationCapturingMode
import com.neome.api.meta.base.dto.StudioDtoLocationCapture
import com.neome.core.common.serializer.sysId.AnyTimeSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLocationCaptureData(
    override val excludeDaysSet: List<EnumDefnDay>? = null,
    override val frequencyBasedOnDistance: Long? = null,
    override val frequencyBasedOnTime: Long? = null,
    @Serializable(with = AnyTimeSer::class) override val fromTime: Types.AnyTime? = null,
    override val roleIdSet: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    @Serializable(with = AnyTimeSer::class) override val toTime: Types.AnyTime? = null,
    override val type: EnumDefnLocationCapturingMode? = null
) : StudioDtoLocationCapture
