package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioVarValueTimeZone
import com.neome.core.common.serializer.sysId.TimeZoneKeySer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueTimeZoneData(
    @Serializable(with = TimeZoneKeySer::class) override val value: Types.TimeZoneKey
) : StudioVarValueTimeZone
