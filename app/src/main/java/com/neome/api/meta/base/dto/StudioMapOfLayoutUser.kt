// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdLayoutUser
import java.util.Map

open class StudioMapOfLayoutUser : StudioBase() {
    lateinit var keys: Array<MetaIdLayoutUser>
    lateinit var map: Map<MetaIdLayoutUser, StudioDtoLayoutUser>
    var mobileDefaultLayoutId: MetaIdLayoutUser? = null
    var webDefaultLayoutId: MetaIdLayoutUser? = null
}
