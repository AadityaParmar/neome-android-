// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnStudioCompArray : DefnField() {
    var fieldIdSet: MetaIdField[]? = null
    var hideAddDeleteBtn: boolean? = null
    var selectedIndex: number? = null
    var showSeparator: boolean? = null
}
