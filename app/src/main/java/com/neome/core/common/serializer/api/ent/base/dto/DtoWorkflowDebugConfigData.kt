package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoWorkflowDebugConfig
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoDiaSer
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoWorkflowDebugConfigData(
    override val breakpointMap: Map<@Serializable(with = MetaIdVdAutoDiaSer::class) Types.MetaIdVdAutoDia, Set<@Serializable(with = MetaIdVdAutoNodeSer::class) Types.MetaIdVdAutoNode>>,
    @Serializable(with = EntUserIdSer::class) override val defaultDebugEntUserId: Types.EntUserId? = null
) : DtoWorkflowDebugConfig
