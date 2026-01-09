package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModule
import com.neome.api.meta.base.dto.StudioModuleMap
import com.neome.core.common.serializer.sysId.MetaIdModuleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioModuleMapData(
    override val keys: Array<@Serializable(with = MetaIdModuleSer::class) Types.MetaIdModule>,
    override val map: Map<@Serializable(with = MetaIdModuleSer::class) Types.MetaIdModule, StudioModule>
) : StudioModuleMap
