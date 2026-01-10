package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdWorkflowControl
import com.neome.api.meta.base.dto.EntVdWorkflowControlMap
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.api.meta.base.dto.EntVdWorkflowControlData
import com.neome.core.common.serializer.sysId.GhostIdSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdWorkflowControlMapData(
    override val keys: List<@Serializable(with = GhostIdSer::class) Types.GhostId>,
    override val map: Map<@Serializable(with = GhostIdSer::class) Types.GhostId, EntVdWorkflowControlData>
) : EntVdWorkflowControlMap
