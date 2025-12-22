// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin

class DefnStudioVarIdParagraphEditor : DefnField() {
    var argBinderFilterVarKindSet: EnumStudioVarKind[]? = null
    val argBinderFormId: MetaIdForm
    var compositeIdSet: MetaIdComposite[]? = null
    var excludeFieldIdSet: MetaIdField[]? = null
    var filterVarKindSet: EnumStudioVarKind[]? = null
    var pluginId: MetaIdPlugin? = null
    var required: boolean? = null
    var showAsEdit: boolean? = null
}
