// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnBuildDate
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

interface DefnFieldDate : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: DefnBuildDate?
  val defaultVar: DefnBuildDate?
  val displayDateFormat: String?
  val max: DefnBuildDate?
  val maxFieldId: MetaIdField?
  val maxVar: DefnBuildDate?
  val min: DefnBuildDate?
  val minFieldId: MetaIdField?
  val minVar: DefnBuildDate?
  val timeZone: TimeZoneKey?
}