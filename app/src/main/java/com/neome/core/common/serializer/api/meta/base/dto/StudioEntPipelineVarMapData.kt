package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPipelineVar
import com.neome.api.meta.base.dto.StudioEntPipelineVarMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntPipelineVarData
import com.neome.core.common.serializer.sysId.MetaIdPipelineVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPipelineVarMapData(
    override val keys: List<@Serializable(with = MetaIdPipelineVarSer::class) Types.MetaIdPipelineVar>,
    override val map: Map<@Serializable(with = MetaIdPipelineVarSer::class) Types.MetaIdPipelineVar, StudioEntPipelineVarData>
) : StudioEntPipelineVarMap
