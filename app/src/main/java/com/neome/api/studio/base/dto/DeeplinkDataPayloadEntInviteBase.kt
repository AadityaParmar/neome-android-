// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MediaIdAvatar

class DeeplinkDataPayloadEntInviteBase : DeeplinkDataPayload() {
    var description: string? = null
    val entId: EntId
    var mediaIdAvatar: MediaIdAvatar? = null
    val name: string
    val senderHandle: string
    val senderName: string
}
