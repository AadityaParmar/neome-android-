package com.neome.core.common.serializer.api.core.base.msg

import com.neome.api.core.base.msg.MsgEntUserIdSet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntUserIdSetData(
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId? = null,
    override val entUserIdSet: List<@Serializable(with = EntUserIdSer::class) Types.EntUserId>? = null
) : MsgEntUserIdSet
