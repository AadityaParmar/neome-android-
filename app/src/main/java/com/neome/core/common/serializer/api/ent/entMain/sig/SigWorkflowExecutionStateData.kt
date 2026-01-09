package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.ent.base.dto.DtoWorkflowParameterInfo
import com.neome.api.ent.base.dto.WorkflowStepSummary
import com.neome.api.ent.entMain.sig.SigWorkflowExecutionState
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.MetaIdVdAutoNodeSer
import com.neome.core.common.serializer.sysId.WorkflowExecutionIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigWorkflowExecutionStateData(
    override val version: String,
    override val createdOn: String,
    @Serializable(with = MetaIdVdAutoNodeSer::class) override val currNodeId: Types.MetaIdVdAutoNode? = null,
    override val currStateKind: EnumWorkflowResultKind,
    @Serializable(with = WorkflowExecutionIdSer::class) override val executionId: Types.WorkflowExecutionId,
    override val executionPathList: Array<@Serializable(with = MetaIdVdAutoNodeSer::class) Types.MetaIdVdAutoNode>? = null,
    override val parameters: Array<DtoWorkflowParameterInfo>? = null,
    override val summaryList: Array<WorkflowStepSummary>? = null,
    override val updatedOn: String,
    override val workflowPointer: EntVdWorkflowPointer
) : SigWorkflowExecutionState
