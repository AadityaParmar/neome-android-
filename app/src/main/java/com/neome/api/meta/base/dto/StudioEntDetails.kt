// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLocationAccuracy
import com.neome.api.meta.base.Types.EnumDefnStoreItem
import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntWallpaper
import com.neome.api.meta.base.Types.TimeZoneKey

open class StudioEntDetails : StudioBase()
{
  var about: String? = null
  var avatarId: MediaIdAvatar? = null
  var displayDateFormat: String? = null
  var hideAddressBook: Boolean? = null
  var languageSet: Array<LanguageKey>? = null
  var locationAccuracy: EnumDefnLocationAccuracy? = null
  lateinit var name: String
  var storeAbout: String? = null
  var storeItemType: EnumDefnStoreItem? = null
  var storeLabelSet: Array<EnumStoreLabel>? = null
  var timeZone: TimeZoneKey? = null
  var wallpaper: StudioEntWallpaper? = null
}