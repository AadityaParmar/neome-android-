package com.neome.core.common.serializer.api.home.base.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.home.base.msg.MsgEntUserId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntUserIdData(
    override val version: String? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId
) : MsgEntUserId
