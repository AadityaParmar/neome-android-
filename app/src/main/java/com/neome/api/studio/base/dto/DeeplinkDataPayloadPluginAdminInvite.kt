// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.meta.base.Types.MediaIdAvatar
import com.neome.api.meta.base.Types.PluginBundleId

open class DeeplinkDataPayloadPluginAdminInvite : DeeplinkDataPayload()
{
  var about: String? = null
  var mediaIdAvatar: MediaIdAvatar? = null
  lateinit var name: String
  lateinit var pluginBundleId: PluginBundleId
  lateinit var senderHandle: String
  lateinit var senderName: String
}