// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBuildDateTime
import com.neome.api.meta.base.dto.StudioFieldDateTime

open class StudioFieldDateTimeRange : StudioFieldDateTime()
{
  var fromDefault: StudioBuildDateTime? = null
  var fromDefaultFieldId: MetaIdField? = null
  var fromDefaultVarId: MetaIdVar? = null
  var toDefault: StudioBuildDateTime? = null
  var toDefaultFieldId: MetaIdField? = null
  var toDefaultVarId: MetaIdVar? = null
}