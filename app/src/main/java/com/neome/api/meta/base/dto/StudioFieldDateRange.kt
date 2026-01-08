// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBuildDate
import com.neome.api.meta.base.dto.StudioFieldDate

interface StudioFieldDateRange : StudioFieldDate
{
  val fromDefault: StudioBuildDate?
  val fromDefaultFieldId: MetaIdField?
  val fromDefaultVarId: MetaIdVar?
  val toDefault: StudioBuildDate?
  val toDefaultFieldId: MetaIdField?
  val toDefaultVarId: MetaIdVar?
}