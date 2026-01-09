// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.StudioDtoArgValue

interface StudioDtoArgValueConstant : StudioDtoArgValue
{
  val type: EnumDefnCompType
  val value: JsonElement?
}