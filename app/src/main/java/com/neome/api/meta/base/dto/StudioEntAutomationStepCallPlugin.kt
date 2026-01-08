// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.PluginApiId
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioEntAutomationStepCallPlugin : StudioEntAutomationStep
{
  val errorFieldId: MetaIdField?
  val errorRetryCountVarId: MetaIdVar?
  val errorRetryDurationVarId: MetaIdVar?
  val exposeOutputAsPipelineVariable: Boolean?
  val inputFormPipelineVarId: MetaIdPipelineParam?
  val iterateOnGridFilterVarId: StudioValueVarIdCondition?
  val iterateOnGridId: MetaIdGrid?
  val outputFormPipelineVarId: MetaIdPipelineParam?
  val pluginInputMappingVarId: MetaIdVar?
  val pluginOutputMappingVarId: MetaIdVar?
  val targetPluginApiId: PluginApiId?
  val targetPluginId: MetaIdPlugin?
}