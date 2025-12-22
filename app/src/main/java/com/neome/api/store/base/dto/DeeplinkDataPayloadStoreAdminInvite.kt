// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.base.dto

import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.StoreItemId

class DeeplinkDataPayloadStoreAdminInvite : DeeplinkDataPayload() {
    var about: string? = null
    var mediaIdAvatar: MediaIdAvatar? = null
    val name: string
    val senderHandle: string
    val senderName: string
    val storeItemId: StoreItemId
}
