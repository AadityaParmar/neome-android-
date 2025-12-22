// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVideoFormat
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldVideo : StudioFieldEditable() {
    var allowPickVideo: boolean? = null
    var maxSize: number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVarId: MetaIdVar? = null
    var showPreview: boolean? = null
    var showPreviewFieldId: MetaIdField? = null
    var showPreviewVarId: MetaIdVar? = null
    var showSize: boolean? = null
    var showSizeFieldId: MetaIdField? = null
    var showSizeVarId: MetaIdVar? = null
    var videoFormatType: EnumDefnVideoFormat? = null
}
