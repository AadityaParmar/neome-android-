package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting
import com.neome.api.meta.base.dto.StudioVarValueScheduler
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildRepeatSettingData
import com.neome.core.common.serializer.sysId.TimeZoneKeySer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueSchedulerData(
    override val repeatSetting: StudioBuildRepeatSettingData? = null,
    override val startDateTime: String? = null,
    @Serializable(with = TimeZoneKeySer::class) override val timeZone: Types.TimeZoneKey? = null
) : StudioVarValueScheduler
