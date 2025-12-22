// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldDate : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: StudioBuildDate? = null
    var defaultVarId: MetaIdVar? = null
    var displayDateFormat: string? = null
    var max: StudioBuildDate? = null
    var maxFieldId: MetaIdField? = null
    var maxVarId: MetaIdVar? = null
    var min: StudioBuildDate? = null
    var minFieldId: MetaIdField? = null
    var minVarId: MetaIdVar? = null
}
