// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

interface DefnStudioCompArray : DefnField {
    val fieldIdSet: List<MetaIdField>?
    val hideAddDeleteBtn: Boolean?
    val selectedIndex: Long?
    val showSeparator: Boolean?
}
