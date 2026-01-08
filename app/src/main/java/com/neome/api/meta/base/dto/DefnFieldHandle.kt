// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldHandle : DefnFieldEditable
{
  val autoPickSelf: Boolean?
  val defaultFieldId: MetaIdField?
  val defaultValue: String?
  val defaultVar: String?
  val invalidDomainSetVar: Array<String>?
  val invalidMobileCountryCodeSetVar: Array<String>?
  val validDomainSetVar: Array<String>?
  val validMobileCountryCodeSetVar: Array<String>?
}