// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldChipSetDeviceSize : DefnFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: Array<EnumDefnDeviceSize>? = null
  var defaultVar: EnumDefnDeviceSize? = null
  var filterKindSet: Array<EnumDefnDeviceSize>? = null
}