// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGridMap
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.Symbol

class DtoEntSpreadsheet {
    val canClear: boolean
    val canExpire: boolean
    val forwardRoleIdSet: MetaIdRole[]
    val hasPartition: boolean
    val insertRoleIdSet: MetaIdRole[]
    var label: string? = null
    var layoutMap: DefnLayoutGridMap? = null
    val name: Symbol
    val removeRoleIdSet: MetaIdRole[]
    val sheetIdHash: string
    val spreadsheetFormId: MetaIdForm
    var spreadsheetRefTokenMap: Record<MetaIdSpreadsheetRef, string>? = null
    val supportOffline: boolean
    val updateRoleIdSet: MetaIdRole[]
}
