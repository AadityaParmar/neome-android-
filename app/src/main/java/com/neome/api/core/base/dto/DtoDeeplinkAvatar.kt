// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.MediaIdAvatar

interface DtoDeeplinkAvatar
{
  val about: String?
  val mediaIdAvatar: MediaIdAvatar?
  val name: String?
}