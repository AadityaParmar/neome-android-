// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DefnFieldHyperlinkRow : DefnFieldEditable() {
    var displayTextVar: DefnDtoText? = null
    var hyperlinkFieldIdSet: MetaIdField[]? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
