// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldHtml : DefnField
{
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVar: DefnDtoParagraph?
  val placeHolder: String?
  val placeHolderFieldId: MetaIdField?
  val placeHolderVar: DefnDtoParagraph?
  val showCloseButton: Boolean?
}