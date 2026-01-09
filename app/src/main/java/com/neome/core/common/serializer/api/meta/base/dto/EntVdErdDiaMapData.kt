package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdErdDia
import com.neome.api.meta.base.dto.EntVdErdDiaMap
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.sysId.MetaIdVdErdDiaSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdErdDiaMapData(
    override val keys: Array<@Serializable(with = MetaIdVdErdDiaSer::class) Types.MetaIdVdErdDia>,
    override val map: Map<@Serializable(with = MetaIdVdErdDiaSer::class) Types.MetaIdVdErdDia, EntVdErdDia>
) : EntVdErdDiaMap
