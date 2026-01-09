package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntUserIdTuple
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class EntUserIdTupleData(
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId? = null
) : EntUserIdTuple
