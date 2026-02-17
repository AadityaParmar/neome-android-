// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueText

interface StudioMapOfValueText : StudioBase
{
  val keys: List<String>
  val map: Map<String, StudioValueText>
}