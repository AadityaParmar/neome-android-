package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoGridRow
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class FieldDtoGridRowData(
    @Serializable(with = EntUserIdSer::class) override val createdBy: Types.EntUserId? = null,
    override val createdOn: String? = null,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId,
    override val rowOrder: String? = null,
    @Serializable(with = EntUserIdSer::class) override val updatedBy: Types.EntUserId? = null,
    override val updatedOn: String? = null,
    override val valueMap: Map<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField, JsonElement>? = null
) : FieldDtoGridRow
