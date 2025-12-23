// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.msg.Msg

open class MsgGroupCreate : Msg() {
    var about: String? = null
    var mediaIdAvatar: MediaIdAvatar? = null
    lateinit var members: Array<EntUserId>
    lateinit var name: String
    lateinit var settings: DtoGroupSettings
}
