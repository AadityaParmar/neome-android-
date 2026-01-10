package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRowAuditTrail
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioSetOfRowAuditTrail
import kotlinx.serialization.Serializable


@Serializable
data class StudioSetOfRowAuditTrailData(
    override val valueSet: List<EnumDefnRowAuditTrail>
) : StudioSetOfRowAuditTrail
