package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginDev
import com.neome.api.meta.base.dto.StudioPluginJar
import com.neome.api.meta.base.dto.StudioPluginResourceMap
import com.neome.api.meta.base.dto.StudioPluginRpc
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginResourceMapData(
    override val dev: StudioPluginDev? = null,
    override val jar: StudioPluginJar? = null,
    override val rpc: StudioPluginRpc? = null
) : StudioPluginResourceMap
