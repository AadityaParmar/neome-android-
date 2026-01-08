// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

interface DefnFieldTimeZone : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: TimeZoneKey?
  val defaultVar: TimeZoneKey?
}