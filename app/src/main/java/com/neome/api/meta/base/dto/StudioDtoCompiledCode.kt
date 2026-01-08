// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfArgBinder

interface StudioDtoCompiledCode : StudioBase
{
  val argBinderMap: StudioMapOfArgBinder?
  val value: String?
}