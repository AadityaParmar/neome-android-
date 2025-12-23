// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldHtml : DefnField()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: String? = null
  var defaultVar: DefnDtoParagraph? = null
  var placeHolder: String? = null
  var placeHolderFieldId: MetaIdField? = null
  var placeHolderVar: DefnDtoParagraph? = null
  var showCloseButton: Boolean? = null
}