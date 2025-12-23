// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDurationUnit
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldDuration : StudioFieldEditable() {
    var autoFormatValue: Boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: FieldDtoDuration? = null
    var defaultVarId: MetaIdVar? = null
    var excludeDurationUnits: Array<EnumDefnDurationUnit>? = null
    var max: FieldDtoDuration? = null
    var maxFieldId: MetaIdField? = null
    var maxVarId: MetaIdVar? = null
    var min: FieldDtoDuration? = null
    var minFieldId: MetaIdField? = null
    var minVarId: MetaIdVar? = null
}
