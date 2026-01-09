package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntUserIdTriple
import com.neome.api.meta.base.dto.EntUserIdTuple
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.UserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class EntUserIdTripleData(
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId? = null,
    @Serializable(with = UserIdSer::class) override val userId: Types.UserId? = null
) : EntUserIdTriple
