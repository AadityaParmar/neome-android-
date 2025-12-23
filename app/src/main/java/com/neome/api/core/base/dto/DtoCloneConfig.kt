// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DtoCloneConfig {
    var cloneAdmin: Boolean? = null
    var cloneEntUser: Boolean? = null
    var cloneSpreadsheetIdSet: Array<MetaIdSpreadsheet>? = null
}
