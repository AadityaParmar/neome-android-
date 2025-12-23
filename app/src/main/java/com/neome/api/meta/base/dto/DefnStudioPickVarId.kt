// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdVar

open class DefnStudioPickVarId : DefnFieldEditable() {
    var excludeVarIdSet: Array<MetaIdVar>? = null
    var filterOptionSet: Array<String>? = null
    var formId: MetaIdForm? = null
    var showAsEdit: Boolean? = null
    var varKind: EnumStudioVarKind? = null
    var varKindSet: Array<EnumStudioVarKind>? = null
}
