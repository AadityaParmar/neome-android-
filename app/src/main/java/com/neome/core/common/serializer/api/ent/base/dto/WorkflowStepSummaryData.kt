package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.WorkflowStepSummary
import kotlinx.serialization.Serializable


@Serializable
data class WorkflowStepSummaryData(
    override val date: String,
    override val message: String
) : WorkflowStepSummary
