// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindFormEvent
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdFormEvent
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEventActionBindingMap
import com.neome.api.meta.base.Symbol

interface StudioFormEvent : StudioBase
{
  val actionBindingMap: StudioEventActionBindingMap?
  val eventFieldIdSet: List<MetaIdField>?
  val kind: EnumDefnKindFormEvent
  val metaId: MetaIdFormEvent
  val name: Symbol
}