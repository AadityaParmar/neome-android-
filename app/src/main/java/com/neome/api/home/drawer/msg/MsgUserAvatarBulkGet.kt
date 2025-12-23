// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.drawer.msg

import com.neome.api.meta.base.Types.EntUserId
import java.util.Map
import com.neome.api.nucleus.base.msg.Msg

open class MsgUserAvatarBulkGet : Msg()
{
  lateinit var userIdVersionMap: Map<EntUserId, String>
}