// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnMapPinShape
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldPinShape : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnMapPinShape? = null
    var defaultVarId: MetaIdVar? = null
}
