package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnEventActionHolder
import com.neome.api.meta.base.dto.DefnEventConditionHolder
import com.neome.api.meta.base.dto.DefnFormEvent
import com.neome.api.meta.base.dto.DefnFormEventMap
import com.neome.core.common.serializer.api.meta.base.dto.DefnEventActionHolderData
import com.neome.core.common.serializer.api.meta.base.dto.DefnEventConditionHolderData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormEventData
import com.neome.core.common.serializer.sysId.MetaIdFormEventSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnFormEventMapData(
    override val actions: DefnEventActionHolderData? = null,
    override val conditions: DefnEventConditionHolderData? = null,
    override val keys: List<@Serializable(with = MetaIdFormEventSer::class) Types.MetaIdFormEvent>,
    override val map: Map<@Serializable(with = MetaIdFormEventSer::class) Types.MetaIdFormEvent, DefnFormEventData>
) : DefnFormEventMap
