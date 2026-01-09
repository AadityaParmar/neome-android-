package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnEmptyFieldVariant
import com.neome.api.meta.base.Types.EnumDefnInsertVariant
import com.neome.api.meta.base.Types.EnumDefnRemoveVariant
import com.neome.api.meta.base.Types.EnumDefnUpdateVariant
import com.neome.api.meta.base.dto.StudioDtoMappingField
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMap
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMapBase
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdMappingSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoMappingFieldMapData(
    override val keys: Array<@Serializable(with = MetaIdMappingSer::class) Types.MetaIdMapping>,
    override val map: Map<@Serializable(with = MetaIdMappingSer::class) Types.MetaIdMapping, StudioDtoMappingField>,
    override val emptyFieldVariant: EnumDefnEmptyFieldVariant? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fromKey: Types.MetaIdField? = null,
    override val insertVariant: EnumDefnInsertVariant? = null,
    override val removeVariant: EnumDefnRemoveVariant? = null,
    @Serializable(with = MetaIdFieldSer::class) override val toKey: Types.MetaIdField? = null,
    override val updateVariant: EnumDefnUpdateVariant? = null
) : StudioDtoMappingFieldMap
