package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioDtoMapping
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMap
import com.neome.api.meta.base.dto.StudioDtoMappingGridMap
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoMappingData(
    override val fieldMappingMap: StudioDtoMappingFieldMap? = null,
    @Serializable(with = MetaIdGridSer::class) override val fromGridId: Types.MetaIdGrid? = null,
    override val gridMappingMap: StudioDtoMappingGridMap? = null,
    @Serializable(with = MetaIdGridSer::class) override val toGridId: Types.MetaIdGrid? = null
) : StudioDtoMapping
