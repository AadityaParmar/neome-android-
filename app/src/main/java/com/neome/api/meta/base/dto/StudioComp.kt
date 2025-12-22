// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

class StudioComp : StudioBase() {
    var aiInstructions: string? = null
    val details: StudioDetails
    var disabled: boolean? = null
    var disabledFieldId: MetaIdField? = null
    var disabledRoleIdSet: MetaIdRole[]? = null
    var disabledVarId: MetaIdVar? = null
    var permissionMatrix: StudioDtoPermissionMatrix? = null
    var type: EnumStudioCompType? = null
}
