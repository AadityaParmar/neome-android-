// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldChipSetDeviceType : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: Array<EnumDeviceType>?
  val defaultVar: EnumDeviceType?
}