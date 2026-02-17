package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioActionHolder
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventConditionHolder
import com.neome.api.meta.base.dto.StudioFormEvent
import com.neome.api.meta.base.dto.StudioFormEventMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioActionHolderData
import com.neome.core.common.serializer.api.meta.base.dto.StudioEventConditionHolderData
import com.neome.core.common.serializer.api.meta.base.dto.StudioFormEventData
import com.neome.core.common.serializer.sysId.MetaIdFormEventSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioFormEventMapData(
    override val actions: StudioActionHolderData? = null,
    override val conditions: StudioEventConditionHolderData? = null,
    override val keys: List<@Serializable(with = MetaIdFormEventSer::class) Types.MetaIdFormEvent>,
    override val map: Map<@Serializable(with = MetaIdFormEventSer::class) Types.MetaIdFormEvent, StudioFormEventData>
) : StudioFormEventMap
