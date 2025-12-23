// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg
import java.util.Set

open class MsgDrawerSearch : Msg()
{
  var filterEntIdSet: Array<EntId>? = null
  var pageSize: Number? = null
  lateinit var searchId: String
  lateinit var searchQuery: String
}