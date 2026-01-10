package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldSetOfEntUserId
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldSetOfEntUserIdData(
    override val displaySet: List<String>? = null,
    override val valueSet: List<@Serializable(with = EntUserIdSer::class) Types.EntUserId>
) : FieldSetOfEntUserId
