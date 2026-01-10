// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface StudioDtoRefTarget : StudioBase {
    val displayFieldIdSet: List<MetaIdField>?
    val filterConditionVarId: StudioValueVarIdCondition?
    val metaId: MetaIdSpreadsheet
    val name: Symbol?
    val overrideLayoutSpreadsheetId: MetaIdLayoutGrid?
}
