// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.EnumIdentityProviderKind
import com.neome.api.nucleus.base.msg.Msg

interface MsgSocialSignIn : Msg
{
  val deviceName: String
  val deviceType: EnumDeviceType
  val identityProviderKind: EnumIdentityProviderKind
  val nickName: String?
  val rememberMe: Boolean?
  val token: String
}