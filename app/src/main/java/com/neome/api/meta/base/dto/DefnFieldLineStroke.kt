// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldLineStroke : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: EnumDefnThemeStroke?
  val defaultVar: EnumDefnThemeStroke?
}