package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdReportDia
import com.neome.api.meta.base.dto.EntVdReportDiaMap
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.api.meta.base.dto.EntVdReportDiaData
import com.neome.core.common.serializer.sysId.MetaIdVdReportDiaSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdReportDiaMapData(
    override val keys: List<@Serializable(with = MetaIdVdReportDiaSer::class) Types.MetaIdVdReportDia>,
    override val map: Map<@Serializable(with = MetaIdVdReportDiaSer::class) Types.MetaIdVdReportDia, EntVdReportDiaData>
) : EntVdReportDiaMap
