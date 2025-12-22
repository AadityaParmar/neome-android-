// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldVoice : DefnFieldEditable() {
    var captureLocation: boolean? = null
    var captureTime: boolean? = null
    var captureUser: boolean? = null
    var maxSize: number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVar: number? = null
    var showCapturedValuesOnAside: EnumDefnCaptureValueKind[]? = null
}
