// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin

class DefnStudioVarIdTextEditor : DefnField() {
    var argBinderFilterVarKindSet: EnumStudioVarKind[]? = null
    var argBinderFormId: MetaIdForm? = null
    var excludeFieldIdSet: MetaIdField[]? = null
    var filterContextOptionSet: string[]? = null
    var filterKindSet: EnumDefnArgBinder[]? = null
    var filterVarKindSet: EnumStudioVarKind[]? = null
    var inputFormId: MetaIdForm? = null
    var pluginConfigFormId: MetaIdForm? = null
    var pluginId: MetaIdPlugin? = null
    var showAsEdit: boolean? = null
}
