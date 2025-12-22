// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.ent.base.dto.DtoWorkflowParameterInfo
import com.neome.api.ent.base.dto.WorkflowStepSummary
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.Types.WorkflowExecutionId
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.nucleus.base.sig.SigVersion

class SigWorkflowExecutionState : SigVersion() {
    val createdOn: string
    var currNodeId: MetaIdVdAutoNode? = null
    val currStateKind: EnumWorkflowResultKind
    val executionId: WorkflowExecutionId
    var executionPathList: MetaIdVdAutoNode[]? = null
    var parameters: DtoWorkflowParameterInfo[]? = null
    var summaryList: WorkflowStepSummary[]? = null
    val updatedOn: string
    val workflowPointer: EntVdWorkflowPointer
}
