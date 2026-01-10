// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldSwitch : DefnFieldEditable {
    val captureLocation: Boolean?
    val captureTime: Boolean?
    val captureUser: Boolean?
    val checkboxLabelVar: DefnDtoText?
    val defaultFieldId: MetaIdField?
    val defaultValue: Boolean?
    val defaultVar: Boolean?
    val labelPlacement: EnumDefnPlacement?
    val labelPlacementVar: EnumDefnPlacement?
    val position: EnumDefnPlacement?
    val positionVar: EnumDefnPlacement?
    val showAsCheckbox: Boolean?
    val showAsCheckboxFieldId: MetaIdField?
    val showAsCheckboxVar: Boolean?
    val showCapturedValuesOnAside: List<EnumDefnCaptureValueKind>?
}
