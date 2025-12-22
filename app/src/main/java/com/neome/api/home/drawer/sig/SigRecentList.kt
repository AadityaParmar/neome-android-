// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoRecentItem
import com.neome.api.nucleus.base.sig.Sig

class SigRecentList : Sig() {
    val recentList: DtoRecentItem[]
    var version: string? = null
}
