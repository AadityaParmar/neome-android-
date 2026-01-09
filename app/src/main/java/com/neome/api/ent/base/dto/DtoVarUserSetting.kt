// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Symbol

interface DtoVarUserSetting
{
  val description: String?
  val kind: EnumDefnUserSettingOptions
  val label: String?
  val name: Symbol
  val optionMap: DefnStudioMapOfDtoOption?
  val value: JsonElement?
  val varId: MetaIdVar
}