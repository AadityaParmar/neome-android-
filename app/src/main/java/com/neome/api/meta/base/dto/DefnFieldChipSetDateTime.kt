// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

interface DefnFieldChipSetDateTime : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: Array<String>?
  val displayDateFormat: String?
  val timeZone: TimeZoneKey?
}