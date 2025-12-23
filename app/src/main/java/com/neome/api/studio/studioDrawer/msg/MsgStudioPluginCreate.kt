// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.meta.base.Types.AdminId
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.PluginBundleId
import com.neome.api.meta.base.dto.StudioPlugin

open class MsgStudioPluginCreate : Msg()
{
  lateinit var adminId: AdminId
  lateinit var pluginBundleId: PluginBundleId
  lateinit var studioPlugin: StudioPlugin
}