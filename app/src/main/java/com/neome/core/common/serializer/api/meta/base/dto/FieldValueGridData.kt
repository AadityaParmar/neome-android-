package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoGridRow
import com.neome.api.meta.base.dto.FieldValueGrid
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueGridData(
    override val keys: Array<@Serializable(with = RowIdSer::class) Types.RowId>,
    override val map: Map<@Serializable(with = RowIdSer::class) Types.RowId, FieldDtoGridRow>
) : FieldValueGrid
