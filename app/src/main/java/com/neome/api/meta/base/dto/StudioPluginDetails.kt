// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStoreLabel
import com.neome.api.meta.base.Types.MediaIdAvatar

open class StudioPluginDetails : StudioBase() {
    var about: String? = null
    var avatarId: MediaIdAvatar? = null
    lateinit var name: String
    var storeAbout: String? = null
    var storeLabelSet: Array<EnumStoreLabel>? = null
}
