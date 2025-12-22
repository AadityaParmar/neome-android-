// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumContactCopyField
import com.neome.api.meta.base.Types.MetaIdField

class StudioFieldRefContact : StudioField() {
    var copyFieldMap: Record<MetaIdField, EnumContactCopyField>? = null
    var editableContactFieldSet: EnumContactCopyField[]? = null
}
