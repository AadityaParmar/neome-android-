// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import java.util.Map
import kotlin.properties.Delegates

open class DtoEntSpreadsheet {
    var canClear: Boolean by Delegates.notNull<Boolean>()
    var canExpire: Boolean by Delegates.notNull<Boolean>()
    lateinit var forwardRoleIdSet: Array<MetaIdRole>
    var hasPartition: Boolean by Delegates.notNull<Boolean>()
    lateinit var insertRoleIdSet: Array<MetaIdRole>
    var label: String? = null
    var layoutMap: DefnLayoutGridMap? = null
    lateinit var name: Symbol
    lateinit var removeRoleIdSet: Array<MetaIdRole>
    lateinit var sheetIdHash: String
    lateinit var spreadsheetFormId: MetaIdForm
    var spreadsheetRefTokenMap: Map<MetaIdSpreadsheetRef, String>? = null
    var supportOffline: Boolean by Delegates.notNull<Boolean>()
    lateinit var updateRoleIdSet: Array<MetaIdRole>
}
