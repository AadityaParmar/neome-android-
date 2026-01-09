package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.SchemaFieldMap
import com.neome.api.meta.base.dto.SchemaGridMap
import com.neome.api.meta.base.dto.SchemaSheet
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.SymbolGridSer
import kotlinx.serialization.Serializable


@Serializable
data class SchemaSheetData(
    override val fieldMap: SchemaFieldMap,
    @Serializable(with = SymbolGridSer::class) override val formSymbol: Types.SymbolGrid,
    override val gridMap: SchemaGridMap,
    @Serializable(with = MetaIdFormSer::class) override val metaId: Types.MetaIdForm
) : SchemaSheet
