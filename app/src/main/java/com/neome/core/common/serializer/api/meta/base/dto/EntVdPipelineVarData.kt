package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdPipelineVar
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.sysId.MetaIdPipelineVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdPipelineVarData(
    @Serializable(with = MetaIdPipelineVarSer::class) override val metaId: Types.MetaIdPipelineVar,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    override val variableForm: FormRefKey? = null
) : EntVdPipelineVar
