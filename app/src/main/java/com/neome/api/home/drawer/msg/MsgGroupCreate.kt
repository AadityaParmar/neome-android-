// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.nucleus.base.msg.Msg

interface MsgGroupCreate : Msg {
    val about: String?
    val mediaIdAvatar: MediaIdAvatar?
    val members: List<EntUserId>
    val name: String
    val settings: DtoGroupSettings
}
