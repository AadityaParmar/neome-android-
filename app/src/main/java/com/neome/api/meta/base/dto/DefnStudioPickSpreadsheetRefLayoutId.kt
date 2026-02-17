// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef

interface DefnStudioPickSpreadsheetRefLayoutId : DefnFieldEditable
{
  val filterLayoutKindSet: List<EnumDefnLayoutGridKind>?
  val formId: MetaIdForm
  val spreadsheetRefId: MetaIdSpreadsheetRef?
}