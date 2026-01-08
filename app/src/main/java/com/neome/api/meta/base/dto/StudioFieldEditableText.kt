// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioFieldEditableText : StudioFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVarId: StudioValueVarIdText?
}