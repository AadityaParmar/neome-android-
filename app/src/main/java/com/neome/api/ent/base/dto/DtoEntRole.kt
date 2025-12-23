// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Symbol

open class DtoEntRole
{
  var description: String? = null
  var label: String? = null
  lateinit var name: Symbol
  lateinit var roleId: MetaIdRole
}