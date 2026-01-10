package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVar
import com.neome.api.meta.base.dto.StudioVarMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioVarData
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarMapData(
    override val keys: List<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar>,
    override val map: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, StudioVarData>
) : StudioVarMap
