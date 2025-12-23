// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.api.meta.base.dto.StudioMapOfSwimlane

open class StudioDtoLayoutKanban : StudioDtoLayoutGrid()
{
  var kanbanFieldId: MetaIdField? = null
  var showCommentCount: Boolean? = null
  var showFieldIdSet: Array<MetaIdField>? = null
  var showFooter: Boolean? = null
  var showSectionName: Boolean? = null
  var sortByFieldIdSet: Array<MetaIdField>? = null
  var sortOrder: EnumDefnSortOrder? = null
  var swimlaneMap: StudioMapOfSwimlane? = null
  var textSize: EnumDefnTextSize? = null
}