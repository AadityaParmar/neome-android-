// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.msg.Msg

open class MsgStudioEntMergeTest : Msg()
{
  lateinit var srcEntId: EntId
  lateinit var tgtEntId: EntId
}