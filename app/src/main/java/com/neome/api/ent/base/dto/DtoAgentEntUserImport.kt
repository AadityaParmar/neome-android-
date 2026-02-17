// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

interface DtoAgentEntUserImport
{
  val entUserId: EntUserId
  val handle: String
  val managerId: EntUserId?
  val nickName: String
  val roleIdSet: List<MetaIdRole>?
  val userVariableValueMap: Map<MetaIdVar, JsonElement>?
}