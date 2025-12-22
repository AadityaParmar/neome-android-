// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldFormListItem : DefnFieldLabel() {
    var editableFieldIdSet: MetaIdField[]? = null
    var isCard: boolean? = null
    var layout: DefnDtoLayoutCardItem? = null
}
