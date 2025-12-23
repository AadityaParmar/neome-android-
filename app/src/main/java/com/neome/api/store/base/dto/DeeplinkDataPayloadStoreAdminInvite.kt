// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.base.dto

import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.StoreItemId

open class DeeplinkDataPayloadStoreAdminInvite : DeeplinkDataPayload()
{
  var about: String? = null
  var mediaIdAvatar: MediaIdAvatar? = null
  lateinit var name: String
  lateinit var senderHandle: String
  lateinit var senderName: String
  lateinit var storeItemId: StoreItemId
}