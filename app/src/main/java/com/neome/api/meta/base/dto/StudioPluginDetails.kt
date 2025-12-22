// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.Types.MediaIdAvatar

class StudioPluginDetails : StudioBase() {
    var about: string? = null
    var avatarId: MediaIdAvatar? = null
    val name: string
    var storeAbout: string? = null
    var storeLabelSet: EnumStoreLabel[]? = null
}
