// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumContactCopyField
import com.neome.api.meta.base.Types.MetaIdField
import java.util.Map

open class StudioFieldRefContact : StudioField() {
    var copyFieldMap: Map<MetaIdField, EnumContactCopyField>? = null
    var editableContactFieldSet: Array<EnumContactCopyField>? = null
}
