package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FormValue
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class FormValueData(
    @Serializable(with = EntUserIdSer::class) override val createdBy: Types.EntUserId? = null,
    override val createdOn: String? = null,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId,
    override val rowOrder: String? = null,
    @Serializable(with = EntUserIdSer::class) override val updatedBy: Types.EntUserId? = null,
    override val updatedOn: String? = null,
    override val valueMap: Map<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp, JsonElement>
) : FormValue

