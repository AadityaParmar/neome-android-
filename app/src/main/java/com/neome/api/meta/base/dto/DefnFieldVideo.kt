// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVideoFormat
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldVideo : DefnFieldEditable() {
    var allowPickVideo: boolean? = null
    var maxSize: number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVar: number? = null
    var showPreview: boolean? = null
    var showPreviewFieldId: MetaIdField? = null
    var showPreviewVar: boolean? = null
    var showSize: boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVar: boolean? = null
    var videoFormatType: EnumDefnVideoFormat? = null
}
