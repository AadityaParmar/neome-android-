package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.home.drawer.msg.MsgEntFilter
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgEntFilterData(
    override val version: String? = null,
    override val filterEntIdSet: List<@Serializable(with = EntIdSer::class) Types.EntId>? = null
) : MsgEntFilter
