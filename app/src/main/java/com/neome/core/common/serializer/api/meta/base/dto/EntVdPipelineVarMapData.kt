package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdPipelineVar
import com.neome.api.meta.base.dto.EntVdPipelineVarMap
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.sysId.MetaIdPipelineVarSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdPipelineVarMapData(
    override val keys: Array<@Serializable(with = MetaIdPipelineVarSer::class) Types.MetaIdPipelineVar>,
    override val map: Map<@Serializable(with = MetaIdPipelineVarSer::class) Types.MetaIdPipelineVar, EntVdPipelineVar>
) : EntVdPipelineVarMap
