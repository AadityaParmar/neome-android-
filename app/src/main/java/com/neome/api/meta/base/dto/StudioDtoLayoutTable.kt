// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.EnumDefnTableLayoutTheme
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

class StudioDtoLayoutTable : StudioDtoLayoutGrid() {
    var allowCustomFilters: boolean? = null
    var columnAlignmentArray: string[]? = null
    var columnSizeSet: string[]? = null
    var footer: StudioMapOfTableFooter? = null
    var freezeFieldIdSet: MetaIdField[]? = null
    var header: StudioMapOfTableHeader? = null
    var hideHeaders: boolean? = null
    var hideRowSeparator: boolean? = null
    var indexColumnName: string? = null
    var masterDetailGridLayoutMap: Record<MetaIdComposite, MetaIdLayoutGrid>? = null
    var pagination: boolean? = null
    var renderingMode: EnumDefnGridRenderingMode? = null
    var rowsPerPage: number? = null
    var showCommentCount: boolean? = null
    var showCompIdSet: MetaIdComp[]? = null
    var showSearchBar: boolean? = null
    var sortByFieldIdSet: MetaIdField[]? = null
    var sortOrder: EnumDefnSortOrder? = null
    var sparklineLayoutMap: Record<MetaIdGrid, MetaIdLayoutGrid>? = null
    var styleMap: StudioMapOfTableStyle? = null
    var theme: EnumDefnTableLayoutTheme? = null
}
