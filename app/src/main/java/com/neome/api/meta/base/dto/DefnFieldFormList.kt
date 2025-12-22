// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSection

class DefnFieldFormList : DefnField() {
    var bgColorFieldId: MetaIdField? = null
    var cardLayoutItemHideBorders: boolean? = null
    var cardLayoutNumOfColumns: number? = null
    var displayItemId: MetaIdField? = null
    var displaySectionId: MetaIdSection? = null
    var editableFieldIdSet: MetaIdField[]? = null
    var hideMenu: boolean? = null
    var ignoreSelection: boolean? = null
    var isPickMany: boolean? = null
    var itemHeight: number? = null
    var layout: DefnDtoLayoutCardItem? = null
    var pickRowOnFieldIdSet: MetaIdField[]? = null
    var showAsCardLayout: boolean? = null
}
