package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdAiAgentControl
import com.neome.api.meta.base.dto.EntVdAiAgentControlMap
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.sysId.GhostIdSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdAiAgentControlMapData(
    override val keys: Array<@Serializable(with = GhostIdSer::class) Types.GhostId>,
    override val map: Map<@Serializable(with = GhostIdSer::class) Types.GhostId, EntVdAiAgentControl>
) : EntVdAiAgentControlMap
