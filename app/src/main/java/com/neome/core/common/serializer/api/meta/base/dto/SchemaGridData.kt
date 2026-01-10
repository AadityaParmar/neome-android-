package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.SchemaFieldMap
import com.neome.api.meta.base.dto.SchemaGrid
import com.neome.core.common.serializer.api.meta.base.dto.SchemaFieldMapData
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.SymbolGridSer
import kotlinx.serialization.Serializable


@Serializable
data class SchemaGridData(
    override val fieldMap: SchemaFieldMapData,
    @Serializable(with = MetaIdGridSer::class) override val metaId: Types.MetaIdGrid,
    @Serializable(with = SymbolGridSer::class) override val parentSymbolGrid: Types.SymbolGrid,
    @Serializable(with = SymbolGridSer::class) override val symbolGrid: Types.SymbolGrid
) : SchemaGrid
