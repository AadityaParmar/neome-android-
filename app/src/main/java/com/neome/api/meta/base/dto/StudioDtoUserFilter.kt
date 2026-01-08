// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder

interface StudioDtoUserFilter : StudioBase
{
  val userPipelineParamId: MetaIdPipelineParam?
  val userVarId: MetaIdVar?
  val users: StudioBuildArgBinder?
}