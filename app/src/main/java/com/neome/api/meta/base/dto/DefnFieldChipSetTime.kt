// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldChipSetTime : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: Array<AnyTime>?
  val defaultVar: Array<AnyTime>?
  val displayDateFormat: String?
}