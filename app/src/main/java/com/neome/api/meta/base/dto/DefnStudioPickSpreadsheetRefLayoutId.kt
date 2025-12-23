// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef

open class DefnStudioPickSpreadsheetRefLayoutId : DefnFieldEditable()
{
  var filterLayoutKindSet: Array<EnumDefnLayoutGridKind>? = null
  lateinit var formId: MetaIdForm
  var spreadsheetRefId: MetaIdSpreadsheetRef? = null
}