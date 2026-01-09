package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdReport
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdReportData(
    override val expanded: Boolean? = null,
    @Serializable(with = MetaIdVdRegionSer::class) override val parentRegionId: Types.MetaIdVdRegion? = null,
    override val point: Point? = null,
    @Serializable(with = MetaIdReportSer::class) override val reportId: Types.MetaIdReport
) : EntVdReport
