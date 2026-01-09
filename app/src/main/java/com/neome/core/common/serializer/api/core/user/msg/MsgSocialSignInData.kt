package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.user.msg.MsgSocialSignIn
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.EnumIdentityProviderKind
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgSocialSignInData(
    override val deviceName: String,
    override val deviceType: EnumDeviceType,
    override val identityProviderKind: EnumIdentityProviderKind,
    override val nickName: String? = null,
    override val rememberMe: Boolean? = null,
    override val token: String
) : MsgSocialSignIn
