// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioField
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

interface StudioFieldHtml : StudioField
{
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVarId: MetaIdVar?
  val placeHolder: String?
  val placeHolderFieldId: MetaIdField?
  val placeHolderVarId: StudioValueVarIdParagraph?
  val showCloseButton: Boolean?
}