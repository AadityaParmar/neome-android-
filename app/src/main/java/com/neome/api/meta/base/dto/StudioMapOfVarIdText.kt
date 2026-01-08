// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioMapOfVarIdText : StudioBase
{
  val keys: Array<String>
  val map: Map<String, StudioValueVarIdText>
}