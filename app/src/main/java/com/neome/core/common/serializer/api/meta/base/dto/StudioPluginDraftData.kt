package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioPlugin
import com.neome.api.meta.base.dto.StudioPluginDraft
import com.neome.core.common.serializer.api.meta.base.dto.StudioPluginData
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginDraftData(
    override val studioPlugin: StudioPluginData? = null
) : StudioPluginDraft
