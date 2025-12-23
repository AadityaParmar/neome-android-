// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldEditable

open class DefnFieldIdentifier : DefnFieldEditable()
{
  var setOnSend: Boolean? = null
  var textPatternVar: DefnDtoText? = null
}