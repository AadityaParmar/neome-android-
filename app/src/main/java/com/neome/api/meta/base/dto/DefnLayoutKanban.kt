// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnStudioMapOfSwimlane
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField

interface DefnLayoutKanban : DefnLayoutGrid
{
  val kanbanFieldId: MetaIdField?
  val showCommentCount: Boolean?
  val showFieldIdSet: List<MetaIdField>?
  val showFooter: Boolean?
  val showSectionName: Boolean?
  val sortByFieldIdSet: List<MetaIdField>?
  val sortOrder: EnumDefnSortOrder?
  val swimlaneMap: DefnStudioMapOfSwimlane?
  val textSize: EnumDefnTextSize?
}