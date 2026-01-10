package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPluginDev
import com.neome.api.meta.base.dto.StudioEntPluginJar
import com.neome.api.meta.base.dto.StudioEntPluginResourceMap
import com.neome.api.meta.base.dto.StudioEntPluginRpc
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginDevData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginJarData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPluginRpcData
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPluginResourceMapData(
    override val dev: StudioEntPluginDevData? = null,
    override val jar: StudioEntPluginJarData? = null,
    override val rpc: StudioEntPluginRpcData? = null
) : StudioEntPluginResourceMap
