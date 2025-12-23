// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

open class EntVdApplyFormula : EntVdAutoStepWithError()
{
  var assignToField: StudioDtoArgValueParameter? = null
  var javascriptFormula: StudioValueCodeJavascript? = null
}