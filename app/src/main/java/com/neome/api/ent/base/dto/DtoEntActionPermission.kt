// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdAction

open class DtoEntActionPermission {
    lateinit var actionId: MetaIdAction
    var deviceSizeSet: Array<EnumDefnDeviceSize>? = null
    var hidden: Boolean? = null
    var menuGroup: String? = null
}
