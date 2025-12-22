// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

class DefnComp {
    var disabled: boolean? = null
    var disabledFieldId: MetaIdField? = null
    var disabledRoleIdSet: MetaIdRole[]? = null
    var disabledVar: boolean? = null
    var hidden: boolean? = null
    var hideDirtyIndicator: boolean? = null
    var invisible: boolean? = null
    var label: string? = null
    var maxWidth: number? = null
    val name: Symbol
    var pb: number? = null
    var permissionMatrix: DefnDtoPermissionMatrix? = null
    var pl: number? = null
    var pr: number? = null
    var pt: number? = null
    var readOnly: boolean? = null
    val type: EnumDefnCompType
}
