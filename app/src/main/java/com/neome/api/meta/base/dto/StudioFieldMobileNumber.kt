// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldMobileNumber : StudioFieldEditable
{
  val autoPickSelf: Boolean?
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVarId: MetaIdVar?
  val invalidCountryCodeSetVarId: MetaIdVar?
  val validCountryCodeSetVarId: MetaIdVar?
}