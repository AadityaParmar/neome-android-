package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueRowId
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueRowIdData(
    override val displayField: String? = null,
    @Serializable(with = RowIdSer::class) override val value: Types.RowId
) : FieldValueRowId
