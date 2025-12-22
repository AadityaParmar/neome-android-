// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

class DefnFieldPickRole : DefnFieldEditable() {
    var allowSystemRoles: boolean? = null
    var callerRoleMap: DefnStudioMapOfDtoOption? = null
    var defaultRoleFieldId: MetaIdField? = null
    var defaultRoleId: MetaIdRole? = null
    var excludeRoleIdSet: MetaIdRole[]? = null
    var filterRoleIdSet: MetaIdRole[]? = null
    var includeOptionMap: DefnStudioMapOfDtoOption? = null
    var pageSize: number? = null
    var showAs: EnumDefnThemePickVariant? = null
}
