// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldTextSize : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnTextSize? = null
    var defaultVarId: MetaIdVar? = null
}
