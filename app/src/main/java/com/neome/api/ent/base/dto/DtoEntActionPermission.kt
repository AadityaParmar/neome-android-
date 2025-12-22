// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdAction

class DtoEntActionPermission {
    val actionId: MetaIdAction
    var deviceSizeSet: EnumDefnDeviceSize[]? = null
    var hidden: boolean? = null
    var menuGroup: string? = null
}
