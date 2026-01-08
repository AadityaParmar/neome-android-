// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStepGenerateDocument

interface StudioEntAutomationStepGenerateImage : StudioEntAutomationStepGenerateDocument
{
  val imageFieldId: MetaIdField?
  val imageFormId: MetaIdForm?
  val imageFormMappingVarId: MetaIdVar?
}