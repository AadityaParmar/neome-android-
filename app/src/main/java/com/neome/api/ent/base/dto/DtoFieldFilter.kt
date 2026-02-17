// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoFieldFilterOption
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Symbol

interface DtoFieldFilter
{
  val defnFieldType: EnumDefnCompType
  val label: String?
  val metaIdField: MetaIdComp
  val name: Symbol
  val valueList: List<DtoFieldFilterOption>?
}