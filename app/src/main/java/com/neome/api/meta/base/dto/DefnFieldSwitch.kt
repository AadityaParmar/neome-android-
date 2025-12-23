// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldSwitch : DefnFieldEditable() {
    var captureLocation: Boolean? = null
    var captureTime: Boolean? = null
    var captureUser: Boolean? = null
    var checkboxLabelVar: DefnDtoText? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: Boolean? = null
    var defaultVar: Boolean? = null
    var labelPlacement: EnumDefnPlacement? = null
    var labelPlacementVar: EnumDefnPlacement? = null
    var position: EnumDefnPlacement? = null
    var positionVar: EnumDefnPlacement? = null
    var showAsCheckbox: Boolean? = null
    var showAsCheckboxFieldId: MetaIdField? = null
    var showAsCheckboxVar: Boolean? = null
    var showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>? = null
}
