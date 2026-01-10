package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntAutomationData
import com.neome.core.common.serializer.sysId.MetaIdAutomationSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationMapData(
    override val keys: List<@Serializable(with = MetaIdAutomationSer::class) Types.MetaIdAutomation>,
    override val map: Map<@Serializable(with = MetaIdAutomationSer::class) Types.MetaIdAutomation, StudioEntAutomationData>
) : StudioEntAutomationMap
