// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class EntVdSsSearch : EntVdAutoStepWithOutput() {
    var maxResultCount: number? = null
    var searchSpreadsheetIdSet: MetaIdSpreadsheet[]? = null
    var searchText: StudioBuildArgBinder? = null
}
