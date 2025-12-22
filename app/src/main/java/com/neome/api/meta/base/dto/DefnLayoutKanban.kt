// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField

class DefnLayoutKanban : DefnLayoutGrid() {
    var kanbanFieldId: MetaIdField? = null
    var showCommentCount: boolean? = null
    var showFieldIdSet: MetaIdField[]? = null
    var showFooter: boolean? = null
    var showSectionName: boolean? = null
    var sortByFieldIdSet: MetaIdField[]? = null
    var sortOrder: EnumDefnSortOrder? = null
    var swimlaneMap: DefnStudioMapOfSwimlane? = null
    var textSize: EnumDefnTextSize? = null
}
