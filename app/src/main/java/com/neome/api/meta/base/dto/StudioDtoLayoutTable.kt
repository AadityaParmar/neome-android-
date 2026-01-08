// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.EnumDefnTableLayoutTheme
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.api.meta.base.dto.StudioMapOfTableFooter
import com.neome.api.meta.base.dto.StudioMapOfTableHeader
import com.neome.api.meta.base.dto.StudioMapOfTableStyle

interface StudioDtoLayoutTable : StudioDtoLayoutGrid
{
  val allowCustomFilters: Boolean?
  val columnAlignmentArray: Array<String>?
  val columnSizeSet: Array<String>?
  val footer: StudioMapOfTableFooter?
  val freezeFieldIdSet: Array<MetaIdField>?
  val header: StudioMapOfTableHeader?
  val hideHeaders: Boolean?
  val hideRowSeparator: Boolean?
  val indexColumnName: String?
  val masterDetailGridLayoutMap: Map<MetaIdComposite, MetaIdLayoutGrid>?
  val pagination: Boolean?
  val renderingMode: EnumDefnGridRenderingMode?
  val rowsPerPage: Long?
  val showCommentCount: Boolean?
  val showCompIdSet: Array<MetaIdComp>?
  val showSearchBar: Boolean?
  val sortByFieldIdSet: Array<MetaIdField>?
  val sortOrder: EnumDefnSortOrder?
  val sparklineLayoutMap: Map<MetaIdGrid, MetaIdLayoutGrid>?
  val styleMap: StudioMapOfTableStyle?
  val theme: EnumDefnTableLayoutTheme?
}