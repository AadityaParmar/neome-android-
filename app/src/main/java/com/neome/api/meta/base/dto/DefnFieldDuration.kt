// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnDurationUnit
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldDuration : DefnFieldEditable
{
  val autoFormatValue: Boolean?
  val defaultFieldId: MetaIdField?
  val defaultValue: FieldDtoDuration?
  val defaultVar: FieldDtoDuration?
  val excludeDurationUnits: Array<EnumDefnDurationUnit>?
  val filterOptionSet: Array<String>?
  val max: FieldDtoDuration?
  val maxFieldId: MetaIdField?
  val maxVar: FieldDtoDuration?
  val min: FieldDtoDuration?
  val minFieldId: MetaIdField?
  val minVar: FieldDtoDuration?
}