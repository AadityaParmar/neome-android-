package com.neome.core.common.serializer.api.app.base.dto

import com.neome.api.app.base.Types.EnumKindNeoScript
import com.neome.api.app.base.dto.DtoNeoScript
import com.neome.api.app.base.dto.DtoNeoScriptPlugin
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoNeoScriptPluginData(
    override val kind: EnumKindNeoScript,
    @Serializable(with = MetaIdPluginSer::class) override val pluginId: Types.MetaIdPlugin? = null
) : DtoNeoScriptPlugin
