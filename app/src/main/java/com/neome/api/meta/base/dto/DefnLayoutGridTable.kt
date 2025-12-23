// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnMapOfTableStyle
import com.neome.api.meta.base.dto.DefnStudioMapOfTableFooter
import com.neome.api.meta.base.dto.DefnStudioMapOfTableHeader
import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.EnumDefnTableLayoutTheme
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

open class DefnLayoutGridTable : DefnLayoutGrid()
{
  var allowCustomFilters: Boolean? = null
  var columnAlignmentArray: Array<String>? = null
  var columnSizeSet: Array<String>? = null
  var footer: DefnStudioMapOfTableFooter? = null
  var freezeFieldIdSet: Array<MetaIdField>? = null
  var header: DefnStudioMapOfTableHeader? = null
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
  var styleMap: DefnMapOfTableStyle? = null
  var theme: EnumDefnTableLayoutTheme? = null
}