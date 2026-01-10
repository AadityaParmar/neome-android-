package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoSwimlane
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.sysId.MetaIdSwimlaneSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoSwimlaneData(
    override val color: StudioDtoColorData? = null,
    @Serializable(with = MetaIdVarSer::class) override val colorVarId: Types.MetaIdVar? = null,
    override val label: String? = null,
    @Serializable(with = MetaIdSwimlaneSer::class) override val metaId: Types.MetaIdSwimlane,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val valueOptionId: String? = null
) : StudioDtoSwimlane
