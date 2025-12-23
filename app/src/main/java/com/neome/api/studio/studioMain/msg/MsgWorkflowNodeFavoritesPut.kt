// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.msg

import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.nucleus.base.msg.Msg

open class MsgWorkflowNodeFavoritesPut : Msg()
{
  lateinit var favoriteSet: Array<EnumDefnKindAutoNode>
}