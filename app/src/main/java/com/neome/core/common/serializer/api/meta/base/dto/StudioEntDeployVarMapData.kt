package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployVar
import com.neome.api.meta.base.dto.StudioEntDeployVarMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntDeployVarData
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntDeployVarMapData(
    override val keys: List<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar>,
    override val map: Map<@Serializable(with = MetaIdVarSer::class) Types.MetaIdVar, StudioEntDeployVarData>
) : StudioEntDeployVarMap
