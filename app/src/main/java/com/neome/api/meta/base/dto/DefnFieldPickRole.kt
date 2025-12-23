// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

open class DefnFieldPickRole : DefnFieldEditable() {
    var allowSystemRoles: Boolean? = null
    var callerRoleMap: DefnStudioMapOfDtoOption? = null
    var defaultRoleFieldId: MetaIdField? = null
    var defaultRoleId: MetaIdRole? = null
    var excludeRoleIdSet: Array<MetaIdRole>? = null
    var filterRoleIdSet: Array<MetaIdRole>? = null
    var includeOptionMap: DefnStudioMapOfDtoOption? = null
    var pageSize: Number? = null
    var showAs: EnumDefnThemePickVariant? = null
}
