// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface StudioDtoArgValueSpreadsheet : StudioDtoArgValue {
    val compositeId: MetaIdComposite?
    val fieldId: MetaIdField?
    val spreadsheetAlias: String?
    val spreadsheetId: MetaIdSpreadsheet?
    val valuePathArray: List<String>?
}
