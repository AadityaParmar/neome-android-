// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVideoFormat
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldVideo : DefnFieldEditable() {
    var allowPickVideo: Boolean? = null
    var maxSize: Number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVar: Number? = null
    var showPreview: Boolean? = null
    var showPreviewFieldId: MetaIdField? = null
    var showPreviewVar: Boolean? = null
    var showSize: Boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVar: Boolean? = null
    var videoFormatType: EnumDefnVideoFormat? = null
}
