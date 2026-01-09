package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationPluginWebhookEvent
import com.neome.api.meta.base.dto.StudioEntAutomationPluginWebhookEventMap
import com.neome.core.common.serializer.sysId.MetaIdEventSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationPluginWebhookEventMapData(
    override val keys: Array<@Serializable(with = MetaIdEventSer::class) Types.MetaIdEvent>,
    override val map: Map<@Serializable(with = MetaIdEventSer::class) Types.MetaIdEvent, StudioEntAutomationPluginWebhookEvent>
) : StudioEntAutomationPluginWebhookEventMap
