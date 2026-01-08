// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioValueVarIdBase

interface StudioValueText : StudioValueVarIdBase
{
  val paramSet: Array<String>?
  val value: String
}