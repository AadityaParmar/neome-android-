// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

class StudioFieldParagraph : StudioFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string? = null
    var defaultVarId: StudioValueVarIdParagraph? = null
    var flexHeight: boolean? = null
    var lineCount: number? = null
    var lineCountFieldId: MetaIdField? = null
    var lineCountVarId: MetaIdVar? = null
    var maxCharCount: number? = null
    var maxCharCountFieldId: MetaIdField? = null
    var maxCharCountVarId: MetaIdVar? = null
    var minCharCount: number? = null
    var minCharCountFieldId: MetaIdField? = null
    var minCharCountVarId: MetaIdVar? = null
}
