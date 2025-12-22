// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

class DefnStudioDtoActionPermission {
    var deviceSizeSet: EnumDefnDeviceSize[]? = null
    var groupIdSet: MetaIdGroup[]? = null
    var hidden: boolean? = null
    var inputMappingVarId: MetaIdVar? = null
    var menuGroup: string? = null
    val metaId: MetaIdAction
    var notAllowedRoleIdSet: MetaIdRole[]? = null
    var outputMappingVarId: MetaIdVar? = null
    val roleIdSet: MetaIdRole[]
    var showMessageTooltip: boolean? = null
}
