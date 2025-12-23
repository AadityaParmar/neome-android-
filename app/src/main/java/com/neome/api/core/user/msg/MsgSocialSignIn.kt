// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.EnumIdentityProviderKind
import com.neome.api.nucleus.base.msg.Msg

open class MsgSocialSignIn : Msg()
{
  lateinit var deviceName: String
  lateinit var deviceType: EnumDeviceType
  lateinit var identityProviderKind: EnumIdentityProviderKind
  var nickName: String? = null
  var rememberMe: Boolean? = null
  lateinit var token: String
}