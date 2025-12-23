// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnBuildDate
import com.neome.api.meta.base.dto.DefnFieldDate
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldDateRange : DefnFieldDate()
{
  var allowSingleDate: Boolean? = null
  var fromDefault: DefnBuildDate? = null
  var fromDefaultFieldId: MetaIdField? = null
  var fromDefaultVar: DefnBuildDate? = null
  var toDefault: DefnBuildDate? = null
  var toDefaultFieldId: MetaIdField? = null
  var toDefaultVar: DefnBuildDate? = null
}