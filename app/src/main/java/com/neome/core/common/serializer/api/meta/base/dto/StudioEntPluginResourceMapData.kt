package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPluginDev
import com.neome.api.meta.base.dto.StudioEntPluginJar
import com.neome.api.meta.base.dto.StudioEntPluginResourceMap
import com.neome.api.meta.base.dto.StudioEntPluginRpc
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPluginResourceMapData(
    override val dev: StudioEntPluginDev? = null,
    override val jar: StudioEntPluginJar? = null,
    override val rpc: StudioEntPluginRpc? = null
) : StudioEntPluginResourceMap
