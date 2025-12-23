// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldSwitch : StudioFieldEditable() {
    var captureLocation: Boolean? = null
    var captureTime: Boolean? = null
    var captureUser: Boolean? = null
    var checkboxLabelVarId: StudioValueVarIdText? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: Boolean? = null
    var defaultVarId: MetaIdVar? = null
    var labelPlacement: EnumDefnPlacement? = null
    var labelPlacementVarId: MetaIdVar? = null
    var position: EnumDefnPlacement? = null
    var positionVarId: MetaIdVar? = null
    var showAsCheckbox: Boolean? = null
    var showAsCheckboxFieldId: MetaIdField? = null
    var showAsCheckboxVarId: MetaIdVar? = null
    var showCapturedValuesOnAside: Array<EnumDefnCaptureValueKind>? = null
}
