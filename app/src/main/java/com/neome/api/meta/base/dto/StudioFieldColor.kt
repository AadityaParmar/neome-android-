// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioFieldEditable

open class StudioFieldColor : StudioFieldEditable()
{
  var defaultFieldId: MetaIdField? = null
  var defaultValue: String? = null
}