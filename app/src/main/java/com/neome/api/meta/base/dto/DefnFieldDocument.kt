// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldDocument : DefnFieldEditable() {
    var disablePreview: boolean? = null
    var fileTypeSet: EnumDefnDocFileExt[]? = null
    var maxSize: number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVar: number? = null
    var showSize: boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVar: boolean? = null
}
