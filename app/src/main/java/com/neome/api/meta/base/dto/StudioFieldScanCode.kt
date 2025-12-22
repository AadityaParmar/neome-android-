// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind

class StudioFieldScanCode : StudioFieldEditable() {
    var barCode: boolean? = null
    var captureLocation: boolean? = null
    var captureTime: boolean? = null
    var captureUser: boolean? = null
    var qrCode: boolean? = null
    var showCapturedValuesOnAside: EnumDefnCaptureValueKind[]? = null
}
