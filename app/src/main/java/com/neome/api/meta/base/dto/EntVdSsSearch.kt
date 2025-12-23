// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class EntVdSsSearch : EntVdAutoStepWithOutput() {
    var maxResultCount: Number? = null
    var searchSpreadsheetIdSet: Array<MetaIdSpreadsheet>? = null
    var searchText: StudioBuildArgBinder? = null
}
