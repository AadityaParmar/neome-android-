// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.dto.StudioEntAction

interface StudioEntActionExecuteWorkflow : StudioEntAction
{
  val automationId: MetaIdAutomation?
  val workflowPointer: EntVdWorkflowPointer?
}