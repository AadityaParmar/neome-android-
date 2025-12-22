// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutUser

class StudioMapOfLayoutUser : StudioBase() {
    val keys: MetaIdLayoutUser[]
    val map: Record<MetaIdLayoutUser, StudioDtoLayoutUser>
    var mobileDefaultLayoutId: MetaIdLayoutUser? = null
    var webDefaultLayoutId: MetaIdLayoutUser? = null
}
