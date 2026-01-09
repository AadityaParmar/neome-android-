package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoMappingField
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMapBase
import com.neome.core.common.serializer.sysId.MetaIdMappingSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoMappingFieldMapBaseData(
    override val keys: Array<@Serializable(with = MetaIdMappingSer::class) Types.MetaIdMapping>,
    override val map: Map<@Serializable(with = MetaIdMappingSer::class) Types.MetaIdMapping, StudioDtoMappingField>
) : StudioDtoMappingFieldMapBase
