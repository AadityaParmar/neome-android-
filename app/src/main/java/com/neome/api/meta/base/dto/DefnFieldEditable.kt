// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

open class DefnFieldEditable : DefnField() {
    var autoFill: Boolean? = null
    var autoFocus: Boolean? = null
    var helperText: String? = null
    var helperTextFieldId: MetaIdField? = null
    var helperTextVar: DefnDtoText? = null
    var hideLabel: Boolean? = null
    var icon: String? = null
    var iconVar: String? = null
    var labelFieldId: MetaIdField? = null
    var placeHolder: String? = null
    var placeHolderFieldId: MetaIdField? = null
    var placeHolderVar: DefnDtoText? = null
    var prefix: String? = null
    var prefixVar: DefnDtoText? = null
    var required: Boolean? = null
    var requiredFieldId: MetaIdField? = null
    var requiredRoleIdSet: Array<MetaIdRole>? = null
    var requiredVar: Boolean? = null
    var suffix: String? = null
    var suffixVar: DefnDtoText? = null
}
