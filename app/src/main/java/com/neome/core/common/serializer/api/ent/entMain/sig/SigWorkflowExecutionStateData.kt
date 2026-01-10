package com.neome.core.common.serializer.api.ent.entMain.sig

import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.ent.base.dto.DtoWorkflowParameterInfo
import com.neome.api.ent.base.dto.WorkflowStepSummary
import com.neome.api.ent.entMain.sig.SigWorkflowExecutionState
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.ent.base.dto.DtoWorkflowParameterInfoData
import com.neome.core.common.serializer.api.ent.base.dto.WorkflowStepSummaryData
import com.neome.core.common.serializer.api.meta.base.dto.EntVdWorkflowPointerData
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
    override val executionPathList: List<@Serializable(with = MetaIdVdAutoNodeSer::class) Types.MetaIdVdAutoNode>? = null,
    override val parameters: List<DtoWorkflowParameterInfoData>? = null,
    override val summaryList: List<WorkflowStepSummaryData>? = null,
    override val updatedOn: String,
    override val workflowPointer: EntVdWorkflowPointerData
) : SigWorkflowExecutionState
