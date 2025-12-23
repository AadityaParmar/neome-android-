// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdRole
import java.util.Set

open class DtoAgentEntUser
{
  lateinit var entUserId: EntUserId
  lateinit var handle: String
  lateinit var nickName: String
  var roleIdSet: Array<MetaIdRole>? = null
  lateinit var userColor: String
}