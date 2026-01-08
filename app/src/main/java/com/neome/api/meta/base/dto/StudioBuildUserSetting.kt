// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase

interface StudioBuildUserSetting : StudioBase
{
  val doNotShowOnUserSettings: Boolean?
  val doNotShowValueToAdmin: Boolean?
  val optionDataSourceVarId: MetaIdVar?
  val userSettingOptionKind: EnumDefnUserSettingOptions
}