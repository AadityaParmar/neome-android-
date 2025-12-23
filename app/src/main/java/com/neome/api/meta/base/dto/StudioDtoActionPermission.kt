// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioDtoActionPermission : StudioBase() {
    var deviceSizeSet: Array<EnumDefnDeviceSize>? = null
    var groupIdSet: Array<MetaIdGroup>? = null
    var hidden: Boolean? = null
    var inputMappingVarId: MetaIdVar? = null
    var menuGroup: String? = null
    lateinit var metaId: MetaIdAction
    var name: Symbol? = null
    var notAllowedRoleIdSet: Array<MetaIdRole>? = null
    var outputMappingVarId: MetaIdVar? = null
    lateinit var roleIdSet: Array<MetaIdRole>
    var showMessageTooltip: Boolean? = null
}
