// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

open class StudioFieldParagraph : StudioFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: String? = null
  var defaultVarId: StudioValueVarIdParagraph? = null
  var flexHeight: Boolean? = null
  var lineCount: Number? = null
  var lineCountFieldId: MetaIdField? = null
  var lineCountVarId: MetaIdVar? = null
  var maxCharCount: Number? = null
  var maxCharCountFieldId: MetaIdField? = null
  var maxCharCountVarId: MetaIdVar? = null
  var minCharCount: Number? = null
  var minCharCountFieldId: MetaIdField? = null
  var minCharCountVarId: MetaIdVar? = null
}