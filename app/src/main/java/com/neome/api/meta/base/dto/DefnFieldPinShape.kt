// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnMapPinShape
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldPinShape : DefnFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: EnumDefnMapPinShape? = null
  var defaultVar: EnumDefnMapPinShape? = null
}