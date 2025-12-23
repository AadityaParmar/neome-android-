// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.SnapshotId

open class MsgEntSnapshot : Msg()
{
  lateinit var name: String
  var parentSnapshotId: SnapshotId? = null
}