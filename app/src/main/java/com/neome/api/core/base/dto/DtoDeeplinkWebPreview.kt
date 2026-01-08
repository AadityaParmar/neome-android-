// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType
import com.neome.api.meta.base.Types.MediaIdAvatar

interface DtoDeeplinkWebPreview
{
  val avatarId: MediaIdAvatar?
  val deeplinkActionType: EnumDeeplinkActionType?
  val desc: String?
  val info: String?
  val senderName: String?
  val targetName: String?
  val title: String?
}