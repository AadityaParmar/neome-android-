// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

open class DefnFieldChipSetDateTime : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: Array<String>? = null
    var displayDateFormat: String? = null
    var timeZone: TimeZoneKey? = null
}
