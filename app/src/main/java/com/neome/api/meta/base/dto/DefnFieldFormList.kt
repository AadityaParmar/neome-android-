// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSection

interface DefnFieldFormList : DefnField {
    val bgColorFieldId: MetaIdField?
    val cardLayoutItemHideBorders: Boolean?
    val cardLayoutNumOfColumns: Long?
    val displayItemId: MetaIdField?
    val displaySectionId: MetaIdSection?
    val editableFieldIdSet: List<MetaIdField>?
    val hideMenu: Boolean?
    val ignoreSelection: Boolean?
    val isPickMany: Boolean?
    val itemHeight: Long?
    val layout: DefnDtoLayoutCardItem?
    val pickRowOnFieldIdSet: List<MetaIdField>?
    val showAsCardLayout: Boolean?
}
