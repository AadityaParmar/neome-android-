// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioDrawer.msg

import com.neome.api.meta.base.Types.MetaId
import com.neome.api.nucleus.base.msg.Msg

open class MsgStudioEntPartMerge : Msg()
{
  lateinit var srcPartId: MetaId
  lateinit var tgtPartId: MetaId
}