package com.neome.core.common.serializer.api.home.aside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.home.aside.msg.MsgGroupInfoGet
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.GroupIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgGroupInfoGetData(
    override val version: String? = null,
    @Serializable(with = GroupIdSer::class) override val groupId: Types.GroupId
) : MsgGroupInfoGet
