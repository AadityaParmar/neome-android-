// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class EntVdSsExecuteQuery : EntVdAutoStepWithOutput() {
    var neoQL: StudioValueCodeNeoQL? = null
    var outputForm: FormRefKey? = null
    var spreadsheetIdSet: MetaIdSpreadsheet[]? = null
}
