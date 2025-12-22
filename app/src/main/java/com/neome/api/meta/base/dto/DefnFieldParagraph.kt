// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldParagraph : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string? = null
    var defaultVar: DefnDtoParagraph? = null
    var flexHeight: boolean? = null
    var lineCount: number? = null
    var lineCountFieldId: MetaIdField? = null
    var lineCountVar: number? = null
    var maxCharCount: number? = null
    var maxCharCountFieldId: MetaIdField? = null
    var maxCharCountVar: number? = null
    var minCharCount: number? = null
    var minCharCountFieldId: MetaIdField? = null
    var minCharCountVar: number? = null
}
