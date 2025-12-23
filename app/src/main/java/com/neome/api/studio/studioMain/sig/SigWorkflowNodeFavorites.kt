// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.studioMain.sig

import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.nucleus.base.sig.SigVersion

open class SigWorkflowNodeFavorites : SigVersion()
{
  lateinit var favoriteSet: Array<EnumDefnKindAutoNode>
}