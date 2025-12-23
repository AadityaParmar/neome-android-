// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.google.gson.JsonElement
import java.util.Map
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.MetaIdVar

open class DtoPickerEntUser
{
  var avatarId: MediaId? = null
  lateinit var entUserId: EntUserId
  lateinit var nickName: String
  var userSettingValueMap: Map<MetaIdVar, Any>? = null
}