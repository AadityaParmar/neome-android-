// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAction

open class DefnStudioBuildActionPermission : DefnField() {
    var allowGrouping: Boolean? = null
    var allowShowMessageTooltip: Boolean? = null
    var allowSystemRoles: Boolean? = null
    var includeActionIdSet: Array<MetaIdAction>? = null
    var includeOptionMap: DefnStudioMapOfDtoOption? = null
    var isGroupAction: Boolean? = null
}
