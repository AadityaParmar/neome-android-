// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoCloneConfig {
    val cloneAdmin: Boolean?
    val cloneEntUser: Boolean?
    val cloneSpreadsheetIdSet: List<MetaIdSpreadsheet>?
}
