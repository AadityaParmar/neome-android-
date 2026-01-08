// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDurationUnit
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldDuration : StudioFieldEditable
{
  val autoFormatValue: Boolean?
  val defaultFieldId: MetaIdField?
  val defaultValue: FieldDtoDuration?
  val defaultVarId: MetaIdVar?
  val excludeDurationUnits: Array<EnumDefnDurationUnit>?
  val max: FieldDtoDuration?
  val maxFieldId: MetaIdField?
  val maxVarId: MetaIdVar?
  val min: FieldDtoDuration?
  val minFieldId: MetaIdField?
  val minVarId: MetaIdVar?
}