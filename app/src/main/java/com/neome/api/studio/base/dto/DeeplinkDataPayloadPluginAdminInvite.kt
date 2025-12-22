// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.PluginBundleId

class DeeplinkDataPayloadPluginAdminInvite : DeeplinkDataPayload() {
    var about: string? = null
    var mediaIdAvatar: MediaIdAvatar? = null
    val name: string
    val pluginBundleId: PluginBundleId
    val senderHandle: string
    val senderName: string
}
