package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoMappingField
import com.neome.core.common.serializer.api.meta.base.dto.StudioBuildArgBinderData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdMappingSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoMappingFieldData(
    override val from: StudioBuildArgBinderData,
    @Serializable(with = MetaIdMappingSer::class) override val metaId: Types.MetaIdMapping,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val primary: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val to: Types.MetaIdField
) : StudioDtoMappingField
