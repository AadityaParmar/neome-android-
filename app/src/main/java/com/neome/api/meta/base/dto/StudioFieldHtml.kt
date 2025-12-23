// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

open class StudioFieldHtml : StudioField()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: String? = null
  var defaultVarId: MetaIdVar? = null
  var placeHolder: String? = null
  var placeHolderFieldId: MetaIdField? = null
  var placeHolderVarId: StudioValueVarIdParagraph? = null
  var showCloseButton: Boolean? = null
}