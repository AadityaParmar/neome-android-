// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

class DtoAgentEntUserImport {
    val entUserId: EntUserId
    val handle: string
    var managerId: EntUserId? = null
    val nickName: string
    var roleIdSet: MetaIdRole[]? = null
    var userVariableValueMap: Record<MetaIdVar, any>? = null
}
