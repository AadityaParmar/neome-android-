// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

class DefnFieldEditable : DefnField() {
    var autoFill: boolean? = null
    var autoFocus: boolean? = null
    var helperText: string? = null
    var helperTextFieldId: MetaIdField? = null
    var helperTextVar: DefnDtoText? = null
    var hideLabel: boolean? = null
    var icon: string? = null
    var iconVar: string? = null
    var labelFieldId: MetaIdField? = null
    var placeHolder: string? = null
    var placeHolderFieldId: MetaIdField? = null
    var placeHolderVar: DefnDtoText? = null
    var prefix: string? = null
    var prefixVar: DefnDtoText? = null
    var required: boolean? = null
    var requiredFieldId: MetaIdField? = null
    var requiredRoleIdSet: MetaIdRole[]? = null
    var requiredVar: boolean? = null
    var suffix: string? = null
    var suffixVar: DefnDtoText? = null
}
