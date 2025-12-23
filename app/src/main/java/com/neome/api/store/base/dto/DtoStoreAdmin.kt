// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.base.dto

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem
import java.util.Set

open class DtoStoreAdmin
{
  lateinit var adminId: AdminId
  lateinit var doNotEditOptionSet: Array<EnumDefnAdminDoNotOptionStoreItem>
  lateinit var doNotShowOptionSet: Array<EnumDefnAdminDoNotOptionStoreItem>
  lateinit var handle: String
  var hasLock: Boolean by Delegates.notNull<Boolean>()
  var isCurrentUser: Boolean? = null
  var isMember: Boolean by Delegates.notNull<Boolean>()
  lateinit var nickName: String
}