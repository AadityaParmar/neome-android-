package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPluginResources
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployPlugin
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class StudioEntDeployPluginData(
    @Serializable(with = MetaIdPluginSer::class) override val metaId: Types.MetaIdPlugin,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val pluginConfigFormValueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>? = null,
    override val pluginType: EnumDefnPluginResources? = null
) : StudioEntDeployPlugin
