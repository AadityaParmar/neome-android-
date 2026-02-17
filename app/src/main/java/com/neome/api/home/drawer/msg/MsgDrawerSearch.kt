// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg

interface MsgDrawerSearch : Msg
{
  val filterEntIdSet: Set<EntId>?
  val pageSize: Long?
  val searchId: String
  val searchQuery: String
}