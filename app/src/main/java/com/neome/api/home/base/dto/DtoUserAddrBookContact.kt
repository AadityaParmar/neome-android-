// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaIdAvatar

class DtoUserAddrBookContact {
    val entUserId: EntUserId
    val handle: string
    var mediaIdAvatar: MediaIdAvatar? = null
    val nickName: string
}
