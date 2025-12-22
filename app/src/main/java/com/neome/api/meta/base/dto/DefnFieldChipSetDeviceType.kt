// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldChipSetDeviceType : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: EnumDeviceType[]? = null
    var defaultVar: EnumDeviceType? = null
}
