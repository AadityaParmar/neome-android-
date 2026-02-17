package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDateOccurrence
import com.neome.api.meta.base.Types.EnumDefnMonth
import com.neome.api.meta.base.Types.EnumDefnRepeatFrequencyKind
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting
import com.neome.api.meta.base.dto.StudioBuildRepeatSettingYears
import com.neome.core.common.serializer.sysId.AnyTimeSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildRepeatSettingYearsData(
    override val endDateTime: String? = null,
    @Serializable(with = MetaIdVarSer::class) override val excludeSetOfDateVarId: Types.MetaIdVar? = null,
    override val frequency: Long? = null,
    override val repeatFrequencyKind: EnumDefnRepeatFrequencyKind,
    override val customDateSet: List<Int>? = null,
    override val dateOccurrence: EnumDefnDateOccurrence? = null,
    override val setOfMonth: List<EnumDefnMonth>? = null,
    override val setOfTime: List<@Serializable(with = AnyTimeSer::class) Types.AnyTime>? = null
) : StudioBuildRepeatSettingYears
