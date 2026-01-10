// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DefnFieldHyperlinkRow : DefnFieldEditable {
    val displayTextVar: DefnDtoText?
    val hyperlinkFieldIdSet: List<MetaIdField>?
    val spreadsheetId: MetaIdSpreadsheet?
}
