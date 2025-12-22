// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

class DefnFieldTimeZone : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: TimeZoneKey? = null
    var defaultVar: TimeZoneKey? = null
}
