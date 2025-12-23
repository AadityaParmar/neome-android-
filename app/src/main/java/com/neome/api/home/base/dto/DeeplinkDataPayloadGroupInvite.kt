// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.core.base.dto.DtoDeeplinkAvatar

open class DeeplinkDataPayloadGroupInvite : DeeplinkDataPayload() {
    lateinit var groupAvatar: DtoDeeplinkAvatar
}
