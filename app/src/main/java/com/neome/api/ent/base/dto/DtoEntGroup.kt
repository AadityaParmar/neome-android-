// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import com.neome.api.meta.base.Types.MetaIdRole

class DtoEntGroup {
    val actionPermissionMap: DtoEntGroupActionPermissionMap
    var freeze: boolean? = null
    var freezeAvatarKind: EnumDefnFreezeAvatarKind? = null
    var freezeSortName: string? = null
    var removeMessagePermissionSet: MetaIdRole[]? = null
}
