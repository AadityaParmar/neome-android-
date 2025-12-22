// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldCounter : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: number? = null
    var defaultVarId: MetaIdVar? = null
    var max: number? = null
    var maxFieldId: MetaIdField? = null
    var maxVarId: MetaIdVar? = null
    var min: number? = null
    var minDisplayValue: number? = null
    var minFieldId: MetaIdField? = null
    var minVarId: MetaIdVar? = null
    var step: number? = null
    var stepFieldId: MetaIdField? = null
    var stepVarId: MetaIdVar? = null
}
