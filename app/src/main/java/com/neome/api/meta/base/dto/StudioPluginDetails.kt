// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.dto.StudioBase

interface StudioPluginDetails : StudioBase
{
  val about: String?
  val avatarId: MediaIdAvatar?
  val name: String
  val storeAbout: String?
  val storeLabelSet: Array<EnumStoreLabel>?
}