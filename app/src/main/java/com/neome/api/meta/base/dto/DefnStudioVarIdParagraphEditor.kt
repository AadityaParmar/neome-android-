// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin

interface DefnStudioVarIdParagraphEditor : DefnField {
    val argBinderFilterVarKindSet: List<EnumStudioVarKind>?
    val argBinderFormId: MetaIdForm
    val compositeIdSet: List<MetaIdComposite>?
    val excludeFieldIdSet: List<MetaIdField>?
    val filterVarKindSet: List<EnumStudioVarKind>?
    val pluginId: MetaIdPlugin?
    val required: Boolean?
    val showAsEdit: Boolean?
}
