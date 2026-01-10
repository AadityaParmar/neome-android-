// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.AnyTime
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioFieldChipSetTime : StudioFieldEditable {
    val defaultFieldId: MetaIdField?
    val defaultValue: List<AnyTime>?
    val defaultVarId: MetaIdVar?
}
