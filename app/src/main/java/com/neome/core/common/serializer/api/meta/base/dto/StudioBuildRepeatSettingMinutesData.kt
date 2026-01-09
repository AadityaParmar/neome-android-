package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnRepeatFrequencyKind
import com.neome.api.meta.base.dto.StudioBuildRepeatSetting
import com.neome.api.meta.base.dto.StudioBuildRepeatSettingMinutes
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildRepeatSettingMinutesData(
    override val endDateTime: String? = null,
    @Serializable(with = MetaIdVarSer::class) override val excludeSetOfDateVarId: Types.MetaIdVar? = null,
    override val frequency: Long? = null,
    override val repeatFrequencyKind: EnumDefnRepeatFrequencyKind
) : StudioBuildRepeatSettingMinutes
