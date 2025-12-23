// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

open class DefnFieldParagraph : DefnFieldEditable() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: String? = null
    var defaultVar: DefnDtoParagraph? = null
    var flexHeight: Boolean? = null
    var lineCount: Number? = null
    var lineCountFieldId: MetaIdField? = null
    var lineCountVar: Number? = null
    var maxCharCount: Number? = null
    var maxCharCountFieldId: MetaIdField? = null
    var maxCharCountVar: Number? = null
    var minCharCount: Number? = null
    var minCharCountFieldId: MetaIdField? = null
    var minCharCountVar: Number? = null
}
