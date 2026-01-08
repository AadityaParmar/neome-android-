// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnDay
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldChipSetDay : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: Array<EnumDefnDay>?
  val defaultVar: Array<EnumDefnDay>?
}