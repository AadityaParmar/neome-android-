// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldChipSetDateTime : StudioFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: Array<String>?
  val displayDateFormat: String?
}