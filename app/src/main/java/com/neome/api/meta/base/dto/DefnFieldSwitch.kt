// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldSwitch : DefnFieldEditable() {
    var captureLocation: boolean? = null
    var captureTime: boolean? = null
    var captureUser: boolean? = null
    var checkboxLabelVar: DefnDtoText? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: boolean? = null
    var defaultVar: boolean? = null
    var labelPlacement: EnumDefnPlacement? = null
    var labelPlacementVar: EnumDefnPlacement? = null
    var position: EnumDefnPlacement? = null
    var positionVar: EnumDefnPlacement? = null
    var showAsCheckbox: boolean? = null
    var showAsCheckboxFieldId: MetaIdField? = null
    var showAsCheckboxVar: boolean? = null
    var showCapturedValuesOnAside: EnumDefnCaptureValueKind[]? = null
}
