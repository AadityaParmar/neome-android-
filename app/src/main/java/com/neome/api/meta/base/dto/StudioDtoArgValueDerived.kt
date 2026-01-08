// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioDtoArgValue

interface StudioDtoArgValueDerived : StudioDtoArgValue
{
  val derivedFieldId: MetaIdField
  val derivedFieldType: EnumDefnCompType?
  val valueBoolean: Boolean?
  val valueDate: String?
  val valueDouble: Long?
  val valueLong: Long?
  val valueOptionId: String?
  val valueText: String?
}