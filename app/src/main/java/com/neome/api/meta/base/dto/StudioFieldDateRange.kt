// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldDateRange : StudioFieldDate() {
    var fromDefault: StudioBuildDate? = null
    var fromDefaultFieldId: MetaIdField? = null
    var fromDefaultVarId: MetaIdVar? = null
    var toDefault: StudioBuildDate? = null
    var toDefaultFieldId: MetaIdField? = null
    var toDefaultVarId: MetaIdVar? = null
}
