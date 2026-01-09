package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.user.msg.MsgGrantBearerToken
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.AppVersionSer
import com.neome.core.common.serializer.sysId.TabIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgGrantBearerTokenData(
    @Serializable(with = AppVersionSer::class) override val appVersion: com.neome.api.nucleus.base.Types.AppVersion,
    override val sendCaller: Boolean? = null,
    @Serializable(with = TabIdSer::class) override val tabId: Types.TabId
) : MsgGrantBearerToken
