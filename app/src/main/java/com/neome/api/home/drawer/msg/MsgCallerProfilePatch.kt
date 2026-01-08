// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.msg.Msg

interface MsgCallerProfilePatch : Msg
{
  val about: String?
  val enterIsSendDesktop: Boolean?
  val enterIsSendMobile: Boolean?
  val firstName: String
  val globalNotificationSetting: DtoNotificationSetting?
  val languageKey: LanguageKey?
  val lastName: String
  val mediaIdAvatar: MediaIdAvatar?
}