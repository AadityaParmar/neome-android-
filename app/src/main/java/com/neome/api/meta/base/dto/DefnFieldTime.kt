// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldTime : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: DefnBuildTime? = null
    var defaultVar: DefnBuildTime? = null
    var displayDateFormat: String? = null
    var max: DefnBuildTime? = null
    var maxFieldId: MetaIdField? = null
    var maxVar: DefnBuildTime? = null
    var min: DefnBuildTime? = null
    var minFieldId: MetaIdField? = null
    var minVar: DefnBuildTime? = null
    var showSecond: Boolean? = null
    var showSecondFieldId: MetaIdField? = null
    var showSecondVar: Boolean? = null
}
