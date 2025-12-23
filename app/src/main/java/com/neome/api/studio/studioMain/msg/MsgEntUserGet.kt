// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.msg.Msg

open class MsgEntUserGet : Msg()
{
  var entId: EntId? = null
  var entUserId: EntUserId? = null
}