// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg
import java.util.Set

interface MsgDrawerSearch : Msg
{
  val filterEntIdSet: Array<EntId>?
  val pageSize: Long?
  val searchId: String
  val searchQuery: String
}