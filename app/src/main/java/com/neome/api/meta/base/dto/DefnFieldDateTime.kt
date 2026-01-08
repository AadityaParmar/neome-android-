// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnBuildDateTime
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

interface DefnFieldDateTime : DefnFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: DefnBuildDateTime?
  val defaultVar: DefnBuildDateTime?
  val displayDateFormat: String?
  val max: DefnBuildDateTime?
  val maxFieldId: MetaIdField?
  val maxVar: DefnBuildDateTime?
  val min: DefnBuildDateTime?
  val minFieldId: MetaIdField?
  val minVar: DefnBuildDateTime?
  val timeZone: TimeZoneKey?
}