package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.EnumDefnTableLayoutTheme
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnLayoutGridTable
import com.neome.api.meta.base.dto.DefnMapOfTableStyle
import com.neome.api.meta.base.dto.DefnStudioMapOfTableFooter
import com.neome.api.meta.base.dto.DefnStudioMapOfTableHeader
import com.neome.core.common.serializer.sysId.MetaIdCompSer
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdGridSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutGridTableData(
    override val allowToSwitchLayoutIdSet: Array<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val bgColorFieldId: Types.MetaIdField? = null,
    override val description: String? = null,
    override val kind: EnumDefnLayoutGridKind,
    override val label: String? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val metaId: Types.MetaIdLayoutGrid,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdFieldSer::class) override val toolTipFieldId: Types.MetaIdField? = null,
    override val allowCustomFilters: Boolean? = null,
    override val columnAlignmentArray: Array<String>? = null,
    override val columnSizeSet: Array<String>? = null,
    override val footer: DefnStudioMapOfTableFooter? = null,
    override val freezeFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val header: DefnStudioMapOfTableHeader? = null,
    override val hideHeaders: Boolean? = null,
    override val hideRowSeparator: Boolean? = null,
    override val indexColumnName: String? = null,
    override val masterDetailGridLayoutMap: Map<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite, @Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>? = null,
    override val pagination: Boolean? = null,
    override val renderingMode: EnumDefnGridRenderingMode? = null,
    override val rowsPerPage: Long? = null,
    override val showCommentCount: Boolean? = null,
    override val showCompIdSet: Array<@Serializable(with = MetaIdCompSer::class) Types.MetaIdComp>? = null,
    override val showSearchBar: Boolean? = null,
    override val sortByFieldIdSet: Array<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val sortOrder: EnumDefnSortOrder? = null,
    override val sparklineLayoutMap: Map<@Serializable(with = MetaIdGridSer::class) Types.MetaIdGrid, @Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>? = null,
    override val styleMap: DefnMapOfTableStyle? = null,
    override val theme: EnumDefnTableLayoutTheme? = null
) : DefnLayoutGridTable
