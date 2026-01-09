package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioPluginDeploy
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginDeployData(
    override val changes: String? = null,
    override val pluginVersion: String
) : StudioPluginDeploy
