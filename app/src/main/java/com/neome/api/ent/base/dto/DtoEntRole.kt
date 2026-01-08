// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Symbol

interface DtoEntRole
{
  val description: String?
  val label: String?
  val name: Symbol
  val roleId: MetaIdRole
}