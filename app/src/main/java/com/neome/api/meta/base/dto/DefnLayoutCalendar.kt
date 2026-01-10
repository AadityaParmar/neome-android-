// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

interface DefnLayoutCalendar : DefnLayoutGrid {
    val colorFieldId: MetaIdField?
    val fromDateFieldId: MetaIdField?
    val fromTimeFieldId: MetaIdField?
    val showFieldIdSet: List<MetaIdField>?
    val titleFieldId: MetaIdField?
    val toDateFieldId: MetaIdField?
    val toTimeFieldId: MetaIdField?
}
