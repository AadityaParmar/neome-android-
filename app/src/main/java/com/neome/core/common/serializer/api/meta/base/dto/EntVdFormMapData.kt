package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdForm
import com.neome.api.meta.base.dto.EntVdFormMap
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.api.meta.base.dto.EntVdFormData
import com.neome.core.common.serializer.sysId.GhostIdSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdFormMapData(
    override val keys: List<@Serializable(with = GhostIdSer::class) Types.GhostId>,
    override val map: Map<@Serializable(with = GhostIdSer::class) Types.GhostId, EntVdFormData>
) : EntVdFormMap
