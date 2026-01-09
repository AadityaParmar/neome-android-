package com.neome.core.common.serializer.api.core.cluster.msg

import com.neome.api.core.cluster.msg.MsgClusterItemDataGet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgClusterItemDataGetData(
    override val clusterItemId: String,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId? = null
) : MsgClusterItemDataGet
