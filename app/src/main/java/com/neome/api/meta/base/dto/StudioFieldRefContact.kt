// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumContactCopyField
import com.neome.api.meta.base.Types.MetaIdField

interface StudioFieldRefContact : StudioField {
    val copyFieldMap: Map<MetaIdField, EnumContactCopyField>?
    val editableContactFieldSet: List<EnumContactCopyField>?
}
