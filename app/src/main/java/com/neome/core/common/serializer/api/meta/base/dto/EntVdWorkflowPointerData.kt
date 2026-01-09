package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.meta.base.dto.StudioBase
import com.neome.core.common.serializer.sysId.MetaIdVdAutoDiaSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdWorkflowPointerData(
    @Serializable(with = MetaIdVdAutoDiaSer::class) override val autoDiaId: Types.MetaIdVdAutoDia? = null,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val startNodeId: Types.MetaIdVdAutoNode? = null
) : EntVdWorkflowPointer
