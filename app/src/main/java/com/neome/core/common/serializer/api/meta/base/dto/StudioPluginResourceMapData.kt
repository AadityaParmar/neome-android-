package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginDev
import com.neome.api.meta.base.dto.StudioPluginJar
import com.neome.api.meta.base.dto.StudioPluginResourceMap
import com.neome.api.meta.base.dto.StudioPluginRpc
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginDevData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginJarData
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginRpcData
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginResourceMapData(
    override val dev: StudioPluginDevData? = null,
    override val jar: StudioPluginJarData? = null,
    override val rpc: StudioPluginRpcData? = null
) : StudioPluginResourceMap
