package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntReport
import com.neome.api.meta.base.dto.StudioEntReportMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntReportData
import com.neome.core.common.serializer.sysId.MetaIdReportSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntReportMapData(
    override val keys: List<@Serializable(with = MetaIdReportSer::class) Types.MetaIdReport>,
    override val map: Map<@Serializable(with = MetaIdReportSer::class) Types.MetaIdReport, StudioEntReportData>
) : StudioEntReportMap
