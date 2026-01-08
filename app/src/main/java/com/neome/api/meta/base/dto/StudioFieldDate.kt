// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBuildDate
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldDate : StudioFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: StudioBuildDate?
  val defaultVarId: MetaIdVar?
  val displayDateFormat: String?
  val max: StudioBuildDate?
  val maxFieldId: MetaIdField?
  val maxVarId: MetaIdVar?
  val min: StudioBuildDate?
  val minFieldId: MetaIdField?
  val minVarId: MetaIdVar?
}