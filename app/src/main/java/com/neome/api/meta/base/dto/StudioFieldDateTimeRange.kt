// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBuildDateTime
import com.neome.api.meta.base.dto.StudioFieldDateTime

interface StudioFieldDateTimeRange : StudioFieldDateTime
{
  val fromDefault: StudioBuildDateTime?
  val fromDefaultFieldId: MetaIdField?
  val fromDefaultVarId: MetaIdVar?
  val toDefault: StudioBuildDateTime?
  val toDefaultFieldId: MetaIdField?
  val toDefaultVarId: MetaIdVar?
}