// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.MetaIdRole

open class DtoEntUserInfo {
    var avatarId: MediaId? = null
    lateinit var entUserId: EntUserId
    var handle: String? = null
    var managerId: EntUserId? = null
    lateinit var nickName: String
    var roleIdSet: Array<MetaIdRole>? = null
    lateinit var userColor: String
}
