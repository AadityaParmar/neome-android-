// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.meta.base.dto.EntVdWorkflowPointer
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdForm

open class DtoEntActionExecuteWorkflow : DtoEntAction()
{
  var automationFormId: MetaIdForm? = null
  var automationId: MetaIdAutomation? = null
  var workflowPointer: EntVdWorkflowPointer? = null
}