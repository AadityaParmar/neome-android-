package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnEmptyFieldVariant
import com.neome.api.meta.base.Types.EnumDefnInsertVariant
import com.neome.api.meta.base.Types.EnumDefnRemoveVariant
import com.neome.api.meta.base.Types.EnumDefnUpdateVariant
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoMappingFieldMapBase
import com.neome.api.meta.base.dto.StudioDtoMappingGrid
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdMappingSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoMappingGridData(
    override val emptyFieldVariant: EnumDefnEmptyFieldVariant? = null,
    override val fieldMappingMap: StudioDtoMappingFieldMapBase? = null,
    @Serializable(with = MetaIdGridSer::class) override val fromGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fromGridKey: Types.MetaIdField? = null,
    override val insertVariant: EnumDefnInsertVariant? = null,
    @Serializable(with = MetaIdMappingSer::class) override val metaId: Types.MetaIdMapping,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val removeVariant: EnumDefnRemoveVariant? = null,
    @Serializable(with = MetaIdGridSer::class) override val toGridId: Types.MetaIdGrid? = null,
    @Serializable(with = MetaIdFieldSer::class) override val toGridKey: Types.MetaIdField? = null,
    override val updateVariant: EnumDefnUpdateVariant? = null
) : StudioDtoMappingGrid
