// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase

open class StudioBuildUserSetting : StudioBase()
{
  var doNotShowOnUserSettings: Boolean? = null
  var doNotShowValueToAdmin: Boolean? = null
  var optionDataSourceVarId: MetaIdVar? = null
  lateinit var userSettingOptionKind: EnumDefnUserSettingOptions
}