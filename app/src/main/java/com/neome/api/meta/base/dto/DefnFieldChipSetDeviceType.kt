// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldChipSetDeviceType : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: Array<EnumDeviceType>? = null
    var defaultVar: EnumDeviceType? = null
}
