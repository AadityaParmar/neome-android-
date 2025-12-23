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

open class SigWorkflowExecutionState : SigVersion() {
    lateinit var createdOn: String
    var currNodeId: MetaIdVdAutoNode? = null
    lateinit var currStateKind: EnumWorkflowResultKind
    lateinit var executionId: WorkflowExecutionId
    var executionPathList: Array<MetaIdVdAutoNode>? = null
    var parameters: Array<DtoWorkflowParameterInfo>? = null
    var summaryList: Array<WorkflowStepSummary>? = null
    lateinit var updatedOn: String
    lateinit var workflowPointer: EntVdWorkflowPointer
}
