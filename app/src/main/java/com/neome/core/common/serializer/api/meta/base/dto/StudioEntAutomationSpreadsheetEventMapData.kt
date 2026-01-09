package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationSpreadsheetEvent
import com.neome.api.meta.base.dto.StudioEntAutomationSpreadsheetEventMap
import com.neome.core.common.serializer.sysId.MetaIdEventSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationSpreadsheetEventMapData(
    override val keys: Array<@Serializable(with = MetaIdEventSer::class) Types.MetaIdEvent>,
    override val map: Map<@Serializable(with = MetaIdEventSer::class) Types.MetaIdEvent, StudioEntAutomationSpreadsheetEvent>
) : StudioEntAutomationSpreadsheetEventMap
