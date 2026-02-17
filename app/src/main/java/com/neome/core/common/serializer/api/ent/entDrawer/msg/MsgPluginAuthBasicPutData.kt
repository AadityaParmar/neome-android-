package com.neome.core.common.serializer.api.ent.entDrawer.msg

import com.neome.api.ent.entDrawer.msg.MsgPluginAuthBasicPut
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdAuthMethodSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgPluginAuthBasicPutData(
    @Serializable(with = MetaIdAuthMethodSer::class) override val authMethodId: Types.MetaIdAuthMethod,
    override val password: String,
    @Serializable(with = MetaIdPluginSer::class) override val pluginId: Types.MetaIdPlugin,
    override val username: String
) : MsgPluginAuthBasicPut
