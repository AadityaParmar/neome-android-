// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldChipSetTime : DefnFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: Array<AnyTime>? = null
  var defaultVar: Array<AnyTime>? = null
  var displayDateFormat: String? = null
}