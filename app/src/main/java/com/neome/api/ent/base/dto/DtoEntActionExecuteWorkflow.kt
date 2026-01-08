// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdForm

interface DtoEntActionExecuteWorkflow : DtoEntAction
{
  val automationFormId: MetaIdForm?
  val automationId: MetaIdAutomation?
  val workflowPointer: EntVdWorkflowPointer?
}