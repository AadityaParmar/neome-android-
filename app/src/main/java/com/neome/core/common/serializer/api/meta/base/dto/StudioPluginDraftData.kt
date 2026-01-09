package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioPlugin
import com.neome.api.meta.base.dto.StudioPluginDraft
import kotlinx.serialization.Serializable


@Serializable
data class StudioPluginDraftData(
    override val studioPlugin: StudioPlugin? = null
) : StudioPluginDraft
