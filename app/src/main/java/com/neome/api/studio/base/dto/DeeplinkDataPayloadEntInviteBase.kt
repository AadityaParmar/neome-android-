// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MediaIdAvatar

open class DeeplinkDataPayloadEntInviteBase : DeeplinkDataPayload() {
    var description: String? = null
    lateinit var entId: EntId
    var mediaIdAvatar: MediaIdAvatar? = null
    lateinit var name: String
    lateinit var senderHandle: String
    lateinit var senderName: String
}
