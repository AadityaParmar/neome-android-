package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.Types.EnumDefnRepeatFrequencyKind
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting
import com.neome.api.meta.base.dto.StudioBuildRepeatSettingWeeks
import com.neome.core.common.serializer.sysId.AnyTimeSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildRepeatSettingWeeksData(
    override val endDateTime: String? = null,
    @Serializable(with = MetaIdVarSer::class) override val excludeSetOfDateVarId: Types.MetaIdVar? = null,
    override val frequency: Long? = null,
    override val repeatFrequencyKind: EnumDefnRepeatFrequencyKind,
    override val setOfRepeatDay: Array<EnumDefnDay>? = null,
    override val setOfTime: Array<@Serializable(with = AnyTimeSer::class) Types.AnyTime>? = null
) : StudioBuildRepeatSettingWeeks
