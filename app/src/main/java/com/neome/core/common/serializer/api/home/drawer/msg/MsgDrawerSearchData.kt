package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.home.drawer.msg.MsgDrawerSearch
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgDrawerSearchData(
    override val filterEntIdSet: List<@Serializable(with = EntIdSer::class) Types.EntId>? = null,
    override val pageSize: Long? = null,
    override val searchId: String,
    override val searchQuery: String
) : MsgDrawerSearch
