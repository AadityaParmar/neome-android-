// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.core.base.msg.MsgVersion
import java.util.Set

open class MsgEntFilter : MsgVersion()
{
  var filterEntIdSet: Array<EntId>? = null
}