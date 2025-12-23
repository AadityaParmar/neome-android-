// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureMode
import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldLocation : DefnFieldEditable() {
    var captureMode: EnumDefnCaptureMode? = null
    var captureTime: Boolean? = null
    var captureUser: Boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: FieldDtoLocation? = null
    var defaultVar: FieldDtoLocation? = null
    var showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>? = null
    var showProgressBar: Boolean? = null
}
