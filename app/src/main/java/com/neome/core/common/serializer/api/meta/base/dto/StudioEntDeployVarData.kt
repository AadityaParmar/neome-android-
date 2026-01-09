package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntDeployVar
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class StudioEntDeployVarData(
    override val kind: EnumStudioVarKind,
    @Serializable(with = MetaIdVarSer::class) override val metaId: Types.MetaIdVar,
    override val varValue: JsonElement? = null
) : StudioEntDeployVar
