package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdReportIOForm
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.VdBase
import com.neome.core.common.serializer.api.meta.base.dto.PointData
import com.neome.core.common.serializer.sysId.MetaIdCompositeSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdReportIOFormData(
    override val uiVersion: String? = null,
    override val expanded: Boolean? = null,
    override val expandedCompositeIdSet: List<@Serializable(with = MetaIdCompositeSer::class) Types.MetaIdComposite>? = null,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm,
    @Serializable(with = MetaIdVdRegionSer::class) override val parentRegionId: Types.MetaIdVdRegion? = null,
    override val point: PointData? = null
) : EntVdReportIOForm
