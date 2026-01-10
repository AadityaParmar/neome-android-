// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaId
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioFieldEditable : StudioField {
    val autoFill: Boolean?
    val autoFocus: Boolean?
    val helperText: String?
    val helperTextFieldId: MetaIdField?
    val helperTextVarId: StudioValueVarIdText?
    val hideLabel: Boolean?
    val icon: String?
    val iconVarId: MetaIdVar?
    val labelFieldId: MetaIdField?
    val placeHolder: String?
    val placeHolderFieldId: MetaIdField?
    val placeHolderVarId: StudioValueVarIdText?
    val prefix: String?
    val prefixVarId: StudioValueVarIdText?
    val refFieldId: MetaIdField?
    val refTargetId: MetaId?
    val required: Boolean?
    val requiredFieldId: MetaIdField?
    val requiredRoleIdSet: List<MetaIdRole>?
    val requiredVarId: MetaIdVar?
    val suffix: String?
    val suffixVarId: StudioValueVarIdText?
}
