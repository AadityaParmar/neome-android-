// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldMobileNumber : DefnFieldEditable
{
  val autoPickSelf: Boolean?
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVar: String?
  val invalidCountryCodeSetVar: List<String>?
  val validCountryCodeSetVar: List<String>?
}