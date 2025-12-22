// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldChipSetDeviceSize : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDefnDeviceSize[]? = null
    var defaultVarId: MetaIdVar? = null
}
