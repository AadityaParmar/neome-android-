// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdText

open class StudioFieldHyperlinkRow : StudioFieldEditable()
{
  var displayTextVarId: StudioValueVarIdText? = null
  var hyperlinkFieldIdSet: Array<MetaIdField>? = null
  var spreadsheetId: MetaIdSpreadsheet? = null
}