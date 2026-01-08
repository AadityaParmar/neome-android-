// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityRule
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfVisibilityCondition
import com.neome.api.meta.base.dto.StudioVisibilityActionMap
import com.neome.api.meta.base.Symbol

interface StudioVisibilityRule : StudioBase
{
  val actionMapIfFalse: StudioVisibilityActionMap
  val actionMapIfTrue: StudioVisibilityActionMap
  val description: String?
  val metaId: MetaIdVisibilityRule
  val name: Symbol
  val visibilityCondMap: StudioMapOfVisibilityCondition?
}