// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioEntReport

interface StudioEntReportPlugin : StudioEntReport
{
  val inputFormMappingVarId: MetaIdVar?
  val outputFormMappingVarId: MetaIdVar?
  val pluginApi: StudioDtoPluginApi?
}