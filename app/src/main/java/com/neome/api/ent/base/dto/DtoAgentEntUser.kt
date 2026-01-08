// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MetaIdRole

interface DtoAgentEntUser
{
  val entUserId: EntUserId
  val handle: String
  val nickName: String
  val roleIdSet: Array<MetaIdRole>?
  val userColor: String
}