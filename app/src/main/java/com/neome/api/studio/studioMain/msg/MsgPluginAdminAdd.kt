// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.dto.StudioModuleSelection

open class MsgPluginAdminAdd : Msg()
{
  lateinit var adminId: AdminId
  var doNotEditOptionSet: Array<EnumDefnAdminDoNotOptionPlugin>? = null
  var doNotShowOptionSet: Array<EnumDefnAdminDoNotOptionPlugin>? = null
  lateinit var handle: String
  var modules: StudioModuleSelection? = null
  lateinit var nickName: String
}