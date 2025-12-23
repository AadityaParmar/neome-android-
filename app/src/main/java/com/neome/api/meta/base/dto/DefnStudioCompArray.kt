// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnStudioCompArray : DefnField() {
    var fieldIdSet: Array<MetaIdField>? = null
    var hideAddDeleteBtn: Boolean? = null
    var selectedIndex: Number? = null
    var showSeparator: Boolean? = null
}
