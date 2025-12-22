// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

class DefnFieldSetOfRole : DefnFieldEditable() {
    var allowSystemRoles: boolean? = null
    var callerRoleMap: DefnStudioMapOfDtoOption? = null
    var defaultRoleFieldId: MetaIdField? = null
    var defaultRoleIdSet: MetaIdRole[]? = null
    var excludeRoleIdSet: MetaIdRole[]? = null
    var filterRoleIdSet: MetaIdRole[]? = null
    var includeOptionMap: DefnStudioMapOfDtoOption? = null
    var pageSize: number? = null
    var showAs: EnumDefnThemePickMultiVariant? = null
}
