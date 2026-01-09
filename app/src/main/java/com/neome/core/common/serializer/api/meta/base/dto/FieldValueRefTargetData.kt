package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueRefTarget
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueRefTargetData(
    override val displayValue: String? = null,
    override val token: String,
    @Serializable(with = RowIdSer::class) override val value: Types.RowId,
    override val version: String? = null
) : FieldValueRefTarget
