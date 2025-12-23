// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnBuildDateTime
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

open class DefnFieldDateTime : DefnFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: DefnBuildDateTime? = null
  var defaultVar: DefnBuildDateTime? = null
  var displayDateFormat: String? = null
  var max: DefnBuildDateTime? = null
  var maxFieldId: MetaIdField? = null
  var maxVar: DefnBuildDateTime? = null
  var min: DefnBuildDateTime? = null
  var minFieldId: MetaIdField? = null
  var minVar: DefnBuildDateTime? = null
  var timeZone: TimeZoneKey? = null
}