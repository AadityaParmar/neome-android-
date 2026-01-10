package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.dto.EntVdBranchIterateSpreadsheet
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioMapOfCondition
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.core.common.serializer.api.meta.base.dto.PointData
import com.neome.core.common.serializer.api.meta.base.dto.SizeData
import com.neome.core.common.serializer.api.meta.base.dto.StudioMapOfConditionData
import com.neome.core.common.serializer.api.meta.base.dto.StudioValueParagraphData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdBranchIterateSpreadsheetData(
    override val uiVersion: String? = null,
    override val kind: EnumDefnKindAutoNode,
    override val logMsg: StudioValueParagraphData? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val metaId: Types.MetaIdVdAutoNode,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdVdRegionSer::class) override val parentRegionId: Types.MetaIdVdRegion? = null,
    override val point: PointData? = null,
    override val size: SizeData? = null,
    override val ascendingOrder: EnumDefnSortOrder? = null,
    override val filterCondition: StudioMapOfConditionData? = null,
    override val numberOfRows: Long? = null,
    override val orderByFieldIds: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    override val selectFieldIds: List<@Serializable(with = MetaIdFieldSer::class) Types.MetaIdField>? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : EntVdBranchIterateSpreadsheet
