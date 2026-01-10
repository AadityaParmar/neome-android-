// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioFieldChipSetDeviceSize : StudioFieldEditable {
    val defaultFieldId: MetaIdField?
    val defaultValue: List<EnumDefnDeviceSize>?
    val defaultVarId: MetaIdVar?
}
