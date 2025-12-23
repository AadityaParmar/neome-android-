// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.MetaIdAction

open class DefnStudioPickActionId : DefnFieldEditable() {
    var excludeActionIdSet: Array<MetaIdAction>? = null
    var filterActionKindSet: Array<EnumDefnKindAction>? = null
    var includeActionIdSet: Array<MetaIdAction>? = null
}
