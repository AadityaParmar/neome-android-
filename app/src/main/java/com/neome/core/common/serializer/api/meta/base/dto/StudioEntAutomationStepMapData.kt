package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioEntAutomationStepMap
import com.neome.core.common.serializer.sysId.MetaIdStepSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntAutomationStepMapData(
    override val keys: Array<@Serializable(with = MetaIdStepSer::class) Types.MetaIdStep>,
    override val map: Map<@Serializable(with = MetaIdStepSer::class) Types.MetaIdStep, StudioEntAutomationStep>
) : StudioEntAutomationStepMap
