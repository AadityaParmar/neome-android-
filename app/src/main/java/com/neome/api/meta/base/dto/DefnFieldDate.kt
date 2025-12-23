// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

open class DefnFieldDate : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: DefnBuildDate? = null
    var defaultVar: DefnBuildDate? = null
    var displayDateFormat: String? = null
    var max: DefnBuildDate? = null
    var maxFieldId: MetaIdField? = null
    var maxVar: DefnBuildDate? = null
    var min: DefnBuildDate? = null
    var minFieldId: MetaIdField? = null
    var minVar: DefnBuildDate? = null
    var timeZone: TimeZoneKey? = null
}
