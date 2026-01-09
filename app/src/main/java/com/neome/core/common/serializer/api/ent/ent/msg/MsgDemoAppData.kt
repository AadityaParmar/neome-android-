package com.neome.core.common.serializer.api.ent.ent.msg

import com.neome.api.ent.ent.msg.MsgDemoApp
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.DemoAppIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgDemoAppData(
    @Serializable(with = DemoAppIdSer::class) override val demoAppId: Types.DemoAppId
) : MsgDemoApp
