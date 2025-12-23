// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.MetaIdForm

open class DefnStudioPickFormId : DefnField()
{
  var alias: String? = null
  var allowSystemForms: Boolean? = null
  var excludeFormIdSet: Array<MetaIdForm>? = null
  var includeOptionMap: DefnStudioMapOfDtoOption? = null
}