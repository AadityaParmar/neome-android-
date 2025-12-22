// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCodeType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldShowCode : StudioFieldEditable() {
    var codeType: EnumDefnCodeType? = null
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string? = null
    var defaultVarId: StudioValueVarIdParagraph? = null
    var showLabel: boolean? = null
    var showLabelFieldId: MetaIdField? = null
    var showLabelVarId: MetaIdVar? = null
}
