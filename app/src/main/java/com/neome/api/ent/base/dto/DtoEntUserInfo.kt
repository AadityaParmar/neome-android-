// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.MetaIdRole

class DtoEntUserInfo {
    var avatarId: MediaId? = null
    val entUserId: EntUserId
    var handle: string? = null
    var managerId: EntUserId? = null
    val nickName: string
    var roleIdSet: MetaIdRole[]? = null
    val userColor: string
}
