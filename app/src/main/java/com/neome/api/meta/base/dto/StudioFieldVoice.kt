// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldVoice : StudioFieldEditable() {
    var captureLocation: Boolean? = null
    var captureTime: Boolean? = null
    var captureUser: Boolean? = null
    var maxSize: Number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVarId: MetaIdVar? = null
    var showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>? = null
}
