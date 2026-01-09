package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildUserSetting
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioBuildUserSettingData(
    override val doNotShowOnUserSettings: Boolean? = null,
    override val doNotShowValueToAdmin: Boolean? = null,
    @Serializable(with = MetaIdVarSer::class) override val optionDataSourceVarId: Types.MetaIdVar? = null,
    override val userSettingOptionKind: EnumDefnUserSettingOptions
) : StudioBuildUserSetting
