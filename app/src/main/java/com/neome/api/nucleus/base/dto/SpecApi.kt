// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.ServiceName
import com.neome.api.nucleus.base.Types.EnumApiMethod
import com.neome.api.nucleus.base.Types.EnumApiToken
import com.neome.api.nucleus.base.Types.EnumApiVer
import com.neome.api.nucleus.base.Types.EnumArtifactMemberType
import com.neome.api.nucleus.base.Types.EnumConnType
import com.neome.api.nucleus.base.Types.EnumDeployKind
import com.neome.api.nucleus.base.Types.EnumScopeType

class SpecApi {
    val allowedConnTypes: EnumConnType[]
    val allowedDeployKinds: EnumDeployKind[]
    val allowedDeviceTypes: EnumDeviceType[]
    var apiDesc: string? = null
    val apiMethod: EnumApiMethod
    val apiName: string
    val apiVer: EnumApiVer
    val artifactMembers: EnumArtifactMemberType[]
    val canBeAccessedViaDeeplink: boolean
    val internal: boolean
    var isDeprecated: boolean? = null
    val logMsg: boolean
    val module: string
    var msgClassName: string? = null
    var msgSchema: string? = null
    var msgSpec: SpecMsg? = null
    val publishes: string[]
    val rateLimitPerSec: number
    val requiredEntAdminScopes: EnumDefnAdminDoNotOptionEnt[]
    val requiredPluginAdminScopes: EnumDefnAdminDoNotOptionPlugin[]
    val requiredStoreAdminScopes: EnumDefnAdminDoNotOptionStoreItem[]
    val rpcUri: string
    val scope: EnumScopeType
    val serviceName: ServiceName
    var sigClassName: string? = null
    var sigSchema: string? = null
    val sigSpec: SpecSig
    var skipEntLockCheck: boolean? = null
    val skipEntUserAuthorization: boolean
    val skipInputValidation: boolean
    val sla: number
    val timeout: number
    val token: EnumApiToken
}
