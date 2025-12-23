// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldChipSetDate : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: Array<String>? = null
    var defaultVarId: MetaIdVar? = null
    var displayDateFormat: String? = null
}
