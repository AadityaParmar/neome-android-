package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.dto.DefnUserSettingVar
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnUserSettingVarData(
    override val description: String? = null,
    override val kind: EnumDefnUserSettingOptions,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val optionMap: DefnStudioMapOfDtoOption? = null,
    @Serializable(with = MetaIdVarSer::class) override val varId: Types.MetaIdVar
) : DefnUserSettingVar
