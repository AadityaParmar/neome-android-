package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationScheduledEvent
import com.neome.api.meta.base.dto.StudioEntAutomationScheduledEventMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntAutomationScheduledEventData
import com.neome.core.common.serializer.sysId.MetaIdEventSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationScheduledEventMapData(
    override val keys: List<@Serializable(with = MetaIdEventSer::class) Types.MetaIdEvent>,
    override val map: Map<@Serializable(with = MetaIdEventSer::class) Types.MetaIdEvent, StudioEntAutomationScheduledEventData>
) : StudioEntAutomationScheduledEventMap
