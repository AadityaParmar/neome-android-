// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.msg.Msg

class MsgGroupCreate : Msg() {
    var about: string? = null
    var mediaIdAvatar: MediaIdAvatar? = null
    val members: EntUserId[]
    val name: string
    val settings: DtoGroupSettings
}
