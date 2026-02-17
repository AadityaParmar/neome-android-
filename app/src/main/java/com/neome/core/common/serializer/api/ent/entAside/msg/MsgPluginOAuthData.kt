package com.neome.core.common.serializer.api.ent.entAside.msg

import com.neome.api.ent.entAside.msg.MsgPluginOAuth
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.MetaIdAuthMethodSer
import com.neome.core.common.serializer.sysId.MetaIdPluginSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgPluginOAuthData(
    @Serializable(with = MetaIdAuthMethodSer::class) override val authMethodId: Types.MetaIdAuthMethod,
    @Serializable(with = MetaIdPluginSer::class) override val pluginId: Types.MetaIdPlugin
) : MsgPluginOAuth
