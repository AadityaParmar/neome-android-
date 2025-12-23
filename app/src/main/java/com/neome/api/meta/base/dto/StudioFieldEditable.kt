// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaId
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldEditable : StudioField() {
    var autoFill: Boolean? = null
    var autoFocus: Boolean? = null
    var helperText: String? = null
    var helperTextFieldId: MetaIdField? = null
    var helperTextVarId: StudioValueVarIdText? = null
    var hideLabel: Boolean? = null
    var icon: String? = null
    var iconVarId: MetaIdVar? = null
    var labelFieldId: MetaIdField? = null
    var placeHolder: String? = null
    var placeHolderFieldId: MetaIdField? = null
    var placeHolderVarId: StudioValueVarIdText? = null
    var prefix: String? = null
    var prefixVarId: StudioValueVarIdText? = null
    var refFieldId: MetaIdField? = null
    var refTargetId: MetaId? = null
    var required: Boolean? = null
    var requiredFieldId: MetaIdField? = null
    var requiredRoleIdSet: Array<MetaIdRole>? = null
    var requiredVarId: MetaIdVar? = null
    var suffix: String? = null
    var suffixVarId: StudioValueVarIdText? = null
}
