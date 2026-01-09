// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.MetaIdVar

interface DtoPickerEntUser
{
  val avatarId: MediaId?
  val entUserId: EntUserId
  val nickName: String
  val userSettingValueMap: Map<MetaIdVar, JsonElement>?
}