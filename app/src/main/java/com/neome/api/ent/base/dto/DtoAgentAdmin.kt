// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.AdminId

open class DtoAgentAdmin
{
  lateinit var adminId: AdminId
  lateinit var handle: String
  lateinit var nickName: String
}