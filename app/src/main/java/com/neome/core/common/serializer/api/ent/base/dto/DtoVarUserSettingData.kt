package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoVarUserSetting
import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class DtoVarUserSettingData(
    override val description: String? = null,
    override val kind: EnumDefnUserSettingOptions,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val optionMap: DefnStudioMapOfDtoOption? = null,
    override val value: JsonElement? = null,
    @Serializable(with = MetaIdVarSer::class) override val varId: Types.MetaIdVar
) : DtoVarUserSetting
