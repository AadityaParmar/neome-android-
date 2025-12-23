// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.GroupId
import com.neome.api.meta.base.Types.MediaIdAvatar

open class DtoMessagePayloadGroup : DtoMessagePayload()
{
  var about: String? = null
  var entId: EntId? = null
  var groupId: GroupId? = null
  var mediaIdAvatar: MediaIdAvatar? = null
  var name: String? = null
}