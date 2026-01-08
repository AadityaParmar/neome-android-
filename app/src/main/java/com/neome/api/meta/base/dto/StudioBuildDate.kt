// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.dto.StudioBase

interface StudioBuildDate : StudioBase
{
  val customValue: String?
  val value: EnumDefnDate?
}