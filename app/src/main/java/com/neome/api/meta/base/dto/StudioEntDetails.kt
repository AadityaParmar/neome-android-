// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLocationAccuracy
import com.neome.api.meta.base.Types.EnumDefnStoreItem
import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.TimeZoneKey

interface StudioEntDetails : StudioBase {
    val about: String?
    val avatarId: MediaIdAvatar?
    val displayDateFormat: String?
    val hideAddressBook: Boolean?
    val languageSet: List<LanguageKey>?
    val locationAccuracy: EnumDefnLocationAccuracy?
    val name: String
    val storeAbout: String?
    val storeItemType: EnumDefnStoreItem?
    val storeLabelSet: List<EnumStoreLabel>?
    val timeZone: TimeZoneKey?
    val wallpaper: StudioEntWallpaper?
}
