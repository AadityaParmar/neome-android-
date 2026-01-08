// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnEntStage

interface DtoEntConfig
{
  val allowClearSpreadsheet: Boolean?
  val confirmBeforeDelete: Boolean?
  val hideObsoleteFeatures: Boolean?
  val lockEnterprise: Boolean?
  val showCompletedWorkflows: Boolean?
  val stage: EnumDefnEntStage?
}