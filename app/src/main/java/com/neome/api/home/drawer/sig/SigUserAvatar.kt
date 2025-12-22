// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.sig

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.nucleus.base.sig.SigVersion

class SigUserAvatar : SigVersion() {
    var about: string? = null
    var avatarId: MediaId? = null
    val entId: EntId
    val entUserId: EntUserId
    val firstName: string
    var handle: string? = null
    var isBlocked: boolean? = null
    var isDeleted: boolean? = null
    val lastName: string
    var nickName: string? = null
    val userColor: string
}
