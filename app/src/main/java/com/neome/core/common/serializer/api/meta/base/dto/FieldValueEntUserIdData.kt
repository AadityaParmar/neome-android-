package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueEntUserId
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueEntUserIdData(
    override val displayField: String? = null,
    @Serializable(with = EntUserIdSer::class) override val value: Types.EntUserId
) : FieldValueEntUserId
