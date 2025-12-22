// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind

class DefnFieldSignature : DefnFieldEditable() {
    var captureLocation: boolean? = null
    var captureTime: boolean? = null
    var captureUser: boolean? = null
    var showCapturedValuesOnAside: EnumDefnCaptureValueKind[]? = null
}
