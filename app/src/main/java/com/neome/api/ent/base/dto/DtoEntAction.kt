// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Symbol

interface DtoEntAction
{
  val actionId: MetaIdAction
  val description: String?
  val icon: String?
  val increaseAsideWidth: Boolean?
  val kind: EnumDefnKindAction
  val label: String?
  val name: Symbol
  val tooltip: String?
}