// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnCodeType
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldShowCode : DefnFieldEditable()
{
  var codeType: EnumDefnCodeType? = null
  var defaultFieldId: MetaIdField? = null
  var defaultValue: String? = null
  var defaultVar: DefnDtoParagraph? = null
  var showLabel: Boolean? = null
  var showLabelFieldId: MetaIdField? = null
  var showLabelVar: Boolean? = null
}