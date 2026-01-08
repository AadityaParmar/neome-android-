// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBuildTime
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldTime : StudioFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: StudioBuildTime?
  val defaultVarId: MetaIdVar?
  val max: StudioBuildTime?
  val maxFieldId: MetaIdField?
  val maxVarId: MetaIdVar?
  val min: StudioBuildTime?
  val minFieldId: MetaIdField?
  val minVarId: MetaIdVar?
  val showSecond: Boolean?
  val showSecondFieldId: MetaIdField?
  val showSecondVarId: MetaIdVar?
}