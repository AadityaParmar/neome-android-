// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.meta.base.Types.MediaIdAvatar

open class DtoDeeplinkWebPreview
{
  var avatarId: MediaIdAvatar? = null
  var deeplinkActionType: EnumDeeplinkActionType? = null
  var desc: String? = null
  var info: String? = null
  var senderName: String? = null
  var targetName: String? = null
  var title: String? = null
}