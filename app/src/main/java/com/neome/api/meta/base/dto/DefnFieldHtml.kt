// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldHtml : DefnField() {
    var defaultFieldId: MetaIdField? = null
    var defaultValue: string? = null
    var defaultVar: DefnDtoParagraph? = null
    var placeHolder: string? = null
    var placeHolderFieldId: MetaIdField? = null
    var placeHolderVar: DefnDtoParagraph? = null
    var showCloseButton: boolean? = null
}
