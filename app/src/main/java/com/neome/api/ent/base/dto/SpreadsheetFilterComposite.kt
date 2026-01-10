// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

interface SpreadsheetFilterComposite {
    val andOr: Boolean?
    val filter: SpreadsheetFilterValue?
    val filterList: List<SpreadsheetFilterComposite>?
}
