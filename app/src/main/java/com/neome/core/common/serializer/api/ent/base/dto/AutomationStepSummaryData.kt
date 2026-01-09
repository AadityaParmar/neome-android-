package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.AutomationStepSummary
import kotlinx.serialization.Serializable


@Serializable
data class AutomationStepSummaryData(
    override val date: String,
    override val message: String
) : AutomationStepSummary
