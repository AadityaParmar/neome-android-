package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.dto.StudioDtoArgValueContext
import com.neome.api.meta.base.dto.StudioDtoArgValueContextCallerSetting
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoArgValueContextCallerSettingData(
    override val kind: EnumDefnArgBinderContext,
    @Serializable(with = MetaIdVarSer::class) override val userSettingVarId: Types.MetaIdVar
) : StudioDtoArgValueContextCallerSetting
