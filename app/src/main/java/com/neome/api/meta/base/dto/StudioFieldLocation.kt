// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureMode
import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldLocation : StudioFieldEditable() {
    var captureMode: EnumDefnCaptureMode? = null
    var captureTime: boolean? = null
    var captureUser: boolean? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: FieldDtoLocation? = null
    var defaultVarId: MetaIdVar? = null
    var showCapturedValuesOnAside: EnumDefnCaptureValueKind[]? = null
}
