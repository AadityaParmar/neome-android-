// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAction

class DefnStudioBuildActionPermission : DefnField() {
    var allowGrouping: boolean? = null
    var allowShowMessageTooltip: boolean? = null
    var allowSystemRoles: boolean? = null
    var includeActionIdSet: MetaIdAction[]? = null
    var includeOptionMap: DefnStudioMapOfDtoOption? = null
    var isGroupAction: boolean? = null
}
