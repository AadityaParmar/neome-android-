// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.Types.MetaIdAuthMethod
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.nucleus.base.msg.Msg

interface MsgPluginOAuth : Msg
{
  val authMethodId: MetaIdAuthMethod
  val pluginId: MetaIdPlugin
}