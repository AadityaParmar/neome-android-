package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgEntFilterNoVersion
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntFilterNoVersionData(
    override val filterEntIdSet: Array<@Serializable(with = EntIdSer::class) Types.EntId>? = null
) : MsgEntFilterNoVersion
