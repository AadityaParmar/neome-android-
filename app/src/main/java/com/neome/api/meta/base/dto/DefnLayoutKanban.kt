// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnStudioMapOfSwimlane
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField

open class DefnLayoutKanban : DefnLayoutGrid()
{
  var kanbanFieldId: MetaIdField? = null
  var showCommentCount: Boolean? = null
  var showFieldIdSet: Array<MetaIdField>? = null
  var showFooter: Boolean? = null
  var showSectionName: Boolean? = null
  var sortByFieldIdSet: Array<MetaIdField>? = null
  var sortOrder: EnumDefnSortOrder? = null
  var swimlaneMap: DefnStudioMapOfSwimlane? = null
  var textSize: EnumDefnTextSize? = null
}