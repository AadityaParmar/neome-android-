// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldDocument : DefnFieldEditable() {
    var disablePreview: Boolean? = null
    var fileTypeSet: Array<EnumDefnDocFileExt>? = null
    var maxSize: Number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVar: Number? = null
    var showSize: Boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVar: Boolean? = null
}
