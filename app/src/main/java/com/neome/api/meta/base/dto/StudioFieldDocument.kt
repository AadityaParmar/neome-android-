// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldDocument : StudioFieldEditable() {
    var fileTypeSet: Array<EnumDefnDocFileExt>? = null
    var maxSize: Number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVarId: MetaIdVar? = null
    var showSize: Boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVarId: MetaIdVar? = null
}
