// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entDrawer.msg

import com.neome.api.meta.base.Types.MetaIdAuthMethod
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.nucleus.base.msg.Msg

interface MsgPluginAuthBasicPut : Msg
{
  val authMethodId: MetaIdAuthMethod
  val password: String
  val pluginId: MetaIdPlugin
  val username: String
}