// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.TimeZoneKey

interface DefnFieldChipSetDate : DefnFieldEditable {
    val defaultFieldId: MetaIdField?
    val defaultValue: List<String>?
    val defaultVar: List<String>?
    val displayDateFormat: String?
    val timeZone: TimeZoneKey?
}
