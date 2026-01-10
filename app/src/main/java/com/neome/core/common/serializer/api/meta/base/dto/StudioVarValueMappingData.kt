package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioDtoMapping
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMap
import com.neome.api.meta.base.dto.StudioDtoMappingGridMap
import com.neome.api.meta.base.dto.StudioVarValueMapping
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoMappingFieldMapData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoMappingGridMapData
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueMappingData(
    override val fieldMappingMap: StudioDtoMappingFieldMapData? = null,
    @Serializable(with = MetaIdGridSer::class) override val fromGridId: Types.MetaIdGrid? = null,
    override val gridMappingMap: StudioDtoMappingGridMapData? = null,
    @Serializable(with = MetaIdGridSer::class) override val toGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdFormSer::class) override val fromFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdPluginSer::class) override val fromPluginId: Types.MetaIdPlugin? = null,
    @Serializable(with = MetaIdFormSer::class) override val toFormId: Types.MetaIdForm? = null,
    @Serializable(with = MetaIdPluginSer::class) override val toPluginId: Types.MetaIdPlugin? = null
) : StudioVarValueMapping
