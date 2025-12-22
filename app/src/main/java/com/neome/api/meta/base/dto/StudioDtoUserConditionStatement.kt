// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindSetOfUser
import com.neome.api.meta.base.Types.EnumDefnUserContext
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

class StudioDtoUserConditionStatement : StudioBase() {
    var derivedRoleIdSet: MetaIdRole[]? = null
    var fieldIdSet: MetaIdField[]? = null
    var kind: EnumDefnKindSetOfUser? = null
    var roleIdSet: MetaIdRole[]? = null
    var userContextSet: EnumDefnUserContext[]? = null
}
