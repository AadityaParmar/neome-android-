// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldSwitch : StudioFieldEditable() {
    var captureLocation: boolean? = null
    var captureTime: boolean? = null
    var captureUser: boolean? = null
    var checkboxLabelVarId: StudioValueVarIdText? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: boolean? = null
    var defaultVarId: MetaIdVar? = null
    var labelPlacement: EnumDefnPlacement? = null
    var labelPlacementVarId: MetaIdVar? = null
    var position: EnumDefnPlacement? = null
    var positionVarId: MetaIdVar? = null
    var showAsCheckbox: boolean? = null
    var showAsCheckboxFieldId: MetaIdField? = null
    var showAsCheckboxVarId: MetaIdVar? = null
    var showCapturedValuesOnAside: EnumDefnCaptureValueKind[]? = null
}
