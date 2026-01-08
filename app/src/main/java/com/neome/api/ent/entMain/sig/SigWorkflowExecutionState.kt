// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.DtoWorkflowParameterInfo
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.Types.WorkflowExecutionId
import com.neome.api.ent.base.dto.WorkflowStepSummary

interface SigWorkflowExecutionState : SigVersion
{
  val createdOn: String
  val currNodeId: MetaIdVdAutoNode?
  val currStateKind: EnumWorkflowResultKind
  val executionId: WorkflowExecutionId
  val executionPathList: Array<MetaIdVdAutoNode>?
  val parameters: Array<DtoWorkflowParameterInfo>?
  val summaryList: Array<WorkflowStepSummary>?
  val updatedOn: String
  val workflowPointer: EntVdWorkflowPointer
}