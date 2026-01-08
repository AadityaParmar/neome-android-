// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBuildDateTime
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldDateTime : StudioFieldEditable
{
  val defaultFieldId: MetaIdField?
  val defaultValue: StudioBuildDateTime?
  val defaultVarId: MetaIdVar?
  val displayDateFormat: String?
  val max: StudioBuildDateTime?
  val maxFieldId: MetaIdField?
  val maxVarId: MetaIdVar?
  val min: StudioBuildDateTime?
  val minFieldId: MetaIdField?
  val minVarId: MetaIdVar?
}