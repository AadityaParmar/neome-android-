// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdRole

class DtoAgentEntUser {
    val entUserId: EntUserId
    val handle: string
    val nickName: string
    var roleIdSet: MetaIdRole[]? = null
    val userColor: string
}
