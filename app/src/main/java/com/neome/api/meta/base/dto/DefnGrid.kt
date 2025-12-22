// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.RowId

class DefnGrid : DefnComp() {
    var actionPermissionMap: DefnStudioMapOfActionPermission? = null
    var fieldIdSet: MetaIdField[]? = null
    var hideAddBtn: boolean? = null
    var isPickMany: boolean? = null
    var layoutGridMap: DefnLayoutGridMap? = null
    var maxRows: number? = null
    var maxRowsVar: number? = null
    val metaId: MetaIdGrid
    var minRows: number? = null
    var minRowsVar: number? = null
    var pickedRowIdSet: RowId[]? = null
    var propertyEditorLabel: string? = null
    var rowActionPermissionMap: DefnStudioMapOfActionPermission? = null
    var showAllRowsFieldId: MetaIdField? = null
    var showExpand: boolean? = null
}
