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

class StudioEntDetails : StudioBase() {
    var about: string? = null
    var avatarId: MediaIdAvatar? = null
    var displayDateFormat: string? = null
    var hideAddressBook: boolean? = null
    var languageSet: LanguageKey[]? = null
    var locationAccuracy: EnumDefnLocationAccuracy? = null
    val name: string
    var storeAbout: string? = null
    var storeItemType: EnumDefnStoreItem? = null
    var storeLabelSet: EnumStoreLabel[]? = null
    var timeZone: TimeZoneKey? = null
    var wallpaper: StudioEntWallpaper? = null
}
