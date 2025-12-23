// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.store.store.msg

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.dto.StudioModuleSelection

open class MsgStoreAdminAdd : Msg()
{
  lateinit var adminId: AdminId
  var doNotEditOptionSet: Array<EnumDefnAdminDoNotOptionStoreItem>? = null
  var doNotShowOptionSet: Array<EnumDefnAdminDoNotOptionStoreItem>? = null
  lateinit var handle: String
  var modules: StudioModuleSelection? = null
  lateinit var nickName: String
}