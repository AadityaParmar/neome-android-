// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityRule
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfVisibilityCondition
import com.neome.api.meta.base.dto.StudioVisibilityActionMap
import com.neome.api.meta.base.Symbol

open class StudioVisibilityRule : StudioBase()
{
  lateinit var actionMapIfFalse: StudioVisibilityActionMap
  lateinit var actionMapIfTrue: StudioVisibilityActionMap
  var description: String? = null
  lateinit var metaId: MetaIdVisibilityRule
  lateinit var name: Symbol
  var visibilityCondMap: StudioMapOfVisibilityCondition? = null
}