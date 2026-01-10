package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoMappingGrid
import com.neome.api.meta.base.dto.StudioDtoMappingGridMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoMappingGridData
import com.neome.core.common.serializer.sysId.MetaIdMappingSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoMappingGridMapData(
    override val keys: List<@Serializable(with = MetaIdMappingSer::class) Types.MetaIdMapping>,
    override val map: Map<@Serializable(with = MetaIdMappingSer::class) Types.MetaIdMapping, StudioDtoMappingGridData>
) : StudioDtoMappingGridMap
