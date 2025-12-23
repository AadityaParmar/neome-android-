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

open class StudioDtoLayoutTable : StudioDtoLayoutGrid()
{
  var allowCustomFilters: Boolean? = null
  var columnAlignmentArray: Array<String>? = null
  var columnSizeSet: Array<String>? = null
  var footer: StudioMapOfTableFooter? = null
  var freezeFieldIdSet: Array<MetaIdField>? = null
  var header: StudioMapOfTableHeader? = null
  var hideHeaders: Boolean? = null
  var hideRowSeparator: Boolean? = null
  var indexColumnName: String? = null
  var masterDetailGridLayoutMap: Map<MetaIdComposite, MetaIdLayoutGrid>? = null
  var pagination: Boolean? = null
  var renderingMode: EnumDefnGridRenderingMode? = null
  var rowsPerPage: Number? = null
  var showCommentCount: Boolean? = null
  var showCompIdSet: Array<MetaIdComp>? = null
  var showSearchBar: Boolean? = null
  var sortByFieldIdSet: Array<MetaIdField>? = null
  var sortOrder: EnumDefnSortOrder? = null
  var sparklineLayoutMap: Map<MetaIdGrid, MetaIdLayoutGrid>? = null
  var styleMap: StudioMapOfTableStyle? = null
  var theme: EnumDefnTableLayoutTheme? = null
}