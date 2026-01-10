package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdErdRef
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.api.meta.base.dto.PointData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdErdRefData(
    override val diamondExpanded: Boolean? = null,
    @Serializable(with = MetaIdVdRegionSer::class) override val diamondParentRegionId: Types.MetaIdVdRegion? = null,
    override val diamondPoint: PointData? = null,
    override val expanded: Boolean? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField,
    override val fromNodeHandleId: String? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val fromNodeId: Types.MetaIdSpreadsheet? = null,
    @Serializable(with = MetaIdVdRegionSer::class) override val parentRegionId: Types.MetaIdVdRegion? = null,
    override val point: PointData? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val toNodeId: Types.MetaIdSpreadsheet? = null
) : EntVdErdRef
