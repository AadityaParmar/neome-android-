// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

class DefnFieldChipSetDateTime : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string[]? = null
    var displayDateFormat: string? = null
    var timeZone: TimeZoneKey? = null
}
