// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldCounter : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: number? = null
    var defaultVar: number? = null
    var justifyContent: EnumDefnPlacement? = null
    var max: number? = null
    var maxFieldId: MetaIdField? = null
    var maxVar: number? = null
    var min: number? = null
    var minDisplayValue: number? = null
    var minFieldId: MetaIdField? = null
    var minVar: number? = null
    var step: number? = null
    var stepFieldId: MetaIdField? = null
    var stepVar: number? = null
}
