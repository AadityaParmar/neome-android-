// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDurationUnit
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldDuration : DefnFieldEditable() {
    var autoFormatValue: boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: FieldDtoDuration? = null
    var defaultVar: FieldDtoDuration? = null
    var excludeDurationUnits: EnumDefnDurationUnit[]? = null
    var filterOptionSet: string[]? = null
    var max: FieldDtoDuration? = null
    var maxFieldId: MetaIdField? = null
    var maxVar: FieldDtoDuration? = null
    var min: FieldDtoDuration? = null
    var minFieldId: MetaIdField? = null
    var minVar: FieldDtoDuration? = null
}
