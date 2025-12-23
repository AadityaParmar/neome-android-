// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.google.gson.JsonElement
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

open class DtoAgentEntUserImport
{
  lateinit var entUserId: EntUserId
  lateinit var handle: String
  var managerId: EntUserId? = null
  lateinit var nickName: String
  var roleIdSet: Array<MetaIdRole>? = null
  var userVariableValueMap: Map<MetaIdVar, Any>? = null
}