// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.MetaIdRole

class DefnFieldCamera : DefnFieldImage() {
    var allowPickImage: boolean? = null
    var captureLocation: boolean? = null
    var captureTime: boolean? = null
    var captureUser: boolean? = null
    var pickImageRoleSet: MetaIdRole[]? = null
    var showCapturedValuesOnAside: EnumDefnCaptureValueKind[]? = null
}
