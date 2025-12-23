// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldTime : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: StudioBuildTime? = null
    var defaultVarId: MetaIdVar? = null
    var max: StudioBuildTime? = null
    var maxFieldId: MetaIdField? = null
    var maxVarId: MetaIdVar? = null
    var min: StudioBuildTime? = null
    var minFieldId: MetaIdField? = null
    var minVarId: MetaIdVar? = null
    var showSecond: Boolean? = null
    var showSecondFieldId: MetaIdField? = null
    var showSecondVarId: MetaIdVar? = null
}
