// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.dto.StudioEntAction

open class StudioEntActionExecuteWorkflow : StudioEntAction()
{
  var automationId: MetaIdAutomation? = null
  var workflowPointer: EntVdWorkflowPointer? = null
}