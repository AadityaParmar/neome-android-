// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnUserSettingOptions
import com.neome.api.meta.base.Types.MetaIdVar

class StudioBuildUserSetting : StudioBase() {
    var doNotShowOnUserSettings: boolean? = null
    var doNotShowValueToAdmin: boolean? = null
    var optionDataSourceVarId: MetaIdVar? = null
    val userSettingOptionKind: EnumDefnUserSettingOptions
}
