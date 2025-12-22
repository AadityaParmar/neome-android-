// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar

class DefnStudioPickVarId : DefnFieldEditable() {
    var excludeVarIdSet: MetaIdVar[]? = null
    var filterOptionSet: string[]? = null
    var formId: MetaIdForm? = null
    var showAsEdit: boolean? = null
    var varKind: EnumStudioVarKind? = null
    var varKindSet: EnumStudioVarKind[]? = null
}
