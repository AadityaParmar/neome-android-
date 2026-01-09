package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntConfig
import com.neome.api.meta.base.Types.EnumDefnEntStage
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntConfigData(
    override val allowClearSpreadsheet: Boolean? = null,
    override val confirmBeforeDelete: Boolean? = null,
    override val hideObsoleteFeatures: Boolean? = null,
    override val lockEnterprise: Boolean? = null,
    override val showCompletedWorkflows: Boolean? = null,
    override val stage: EnumDefnEntStage? = null
) : DtoEntConfig
