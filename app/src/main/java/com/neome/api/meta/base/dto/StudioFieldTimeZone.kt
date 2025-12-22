// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.TimeZoneKey

class StudioFieldTimeZone : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: TimeZoneKey? = null
    var defaultVarId: MetaIdVar? = null
}
