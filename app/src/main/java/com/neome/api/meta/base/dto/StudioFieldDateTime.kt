// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBuildDateTime
import com.neome.api.meta.base.dto.StudioFieldEditable

open class StudioFieldDateTime : StudioFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: StudioBuildDateTime? = null
  var defaultVarId: MetaIdVar? = null
  var displayDateFormat: String? = null
  var max: StudioBuildDateTime? = null
  var maxFieldId: MetaIdField? = null
  var maxVarId: MetaIdVar? = null
  var min: StudioBuildDateTime? = null
  var minFieldId: MetaIdField? = null
  var minVarId: MetaIdVar? = null
}