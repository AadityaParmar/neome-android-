// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

class DefnFieldChipSetDate : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string[]? = null
    var defaultVar: string[]? = null
    var displayDateFormat: string? = null
    var timeZone: TimeZoneKey? = null
}
