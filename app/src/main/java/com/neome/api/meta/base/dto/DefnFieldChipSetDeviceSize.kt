// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldChipSetDeviceSize : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: Array<EnumDefnDeviceSize>?
  val defaultVar: EnumDefnDeviceSize?
  val filterKindSet: Array<EnumDefnDeviceSize>?
}