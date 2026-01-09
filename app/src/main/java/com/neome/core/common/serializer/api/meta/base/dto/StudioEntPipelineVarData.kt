package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntPipelineVar
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdPipelineVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntPipelineVarData(
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdPipelineVarSer::class) override val metaId: Types.MetaIdPipelineVar,
    @Serializable(with = SymbolSer::class) override val name: Symbol
) : StudioEntPipelineVar
