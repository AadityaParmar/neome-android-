// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVisibilityAction
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVisibilityAction

open class StudioVisibilityActionMap : StudioBase()
{
  lateinit var keys: Array<MetaIdVisibilityAction>
  lateinit var map: Map<MetaIdVisibilityAction, StudioVisibilityAction>
}