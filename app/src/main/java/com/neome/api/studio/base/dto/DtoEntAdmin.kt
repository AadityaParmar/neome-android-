// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.AdminId
import java.util.Date
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt
import java.util.Set
import com.neome.api.meta.base.dto.StudioModuleSelection

open class DtoEntAdmin
{
  lateinit var adminId: AdminId
  lateinit var createdOn: String
  var doNotEditOptionSet: Array<EnumDefnAdminDoNotOptionEnt>? = null
  var doNotShowOptionSet: Array<EnumDefnAdminDoNotOptionEnt>? = null
  lateinit var handle: String
  var hasLock: Boolean by Delegates.notNull<Boolean>()
  var isCurrentUser: Boolean? = null
  var isMember: Boolean by Delegates.notNull<Boolean>()
  lateinit var modules: StudioModuleSelection
  lateinit var nickName: String
  lateinit var updatedOn: String
}