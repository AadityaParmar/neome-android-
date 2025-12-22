// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPermission
import com.neome.api.meta.base.Types.MetaIdRole

class StudioDtoPermissionMatrix : StudioBase() {
    var defaultPermission: EnumDefnPermission? = null
    val keys: MetaIdRole[]
    val map: Record<MetaIdRole, EnumDefnPermission>
}
