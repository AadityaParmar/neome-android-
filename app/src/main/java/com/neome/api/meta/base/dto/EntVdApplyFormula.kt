// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter
import com.neome.api.meta.base.dto.StudioValueCodeJavascript

interface EntVdApplyFormula : EntVdAutoStepWithError
{
  val assignToField: StudioDtoArgValueParameter?
  val javascriptFormula: StudioValueCodeJavascript?
}