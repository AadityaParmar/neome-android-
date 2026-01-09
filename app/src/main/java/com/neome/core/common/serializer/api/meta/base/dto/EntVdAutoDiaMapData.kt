package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdAutoDia
import com.neome.api.meta.base.dto.EntVdAutoDiaMap
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.sysId.MetaIdVdAutoDiaSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdAutoDiaMapData(
    override val keys: Array<@Serializable(with = MetaIdVdAutoDiaSer::class) Types.MetaIdVdAutoDia>,
    override val map: Map<@Serializable(with = MetaIdVdAutoDiaSer::class) Types.MetaIdVdAutoDia, EntVdAutoDia>
) : EntVdAutoDiaMap
