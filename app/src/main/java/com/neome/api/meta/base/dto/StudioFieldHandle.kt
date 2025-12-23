// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

open class StudioFieldHandle : StudioFieldEditable()
{
  var autoPickSelf: Boolean? = null
  var defaultFieldId: MetaIdField? = null
  var defaultValue: String? = null
  var defaultVarId: MetaIdVar? = null
  var invalidDomainVarId: MetaIdVar? = null
  var invalidMobileCountryCodeSetVarId: MetaIdVar? = null
  var validDomainVarId: MetaIdVar? = null
  var validMobileCountryCodeSetVarId: MetaIdVar? = null
}