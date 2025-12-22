// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.MetaIdAction

class DefnStudioPickActionId : DefnFieldEditable() {
    var excludeActionIdSet: MetaIdAction[]? = null
    var filterActionKindSet: EnumDefnKindAction[]? = null
    var includeActionIdSet: MetaIdAction[]? = null
}
