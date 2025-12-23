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
import kotlin.properties.Delegates

open class SpecApi {
    lateinit var allowedConnTypes: Array<EnumConnType>
    lateinit var allowedDeployKinds: Array<EnumDeployKind>
    lateinit var allowedDeviceTypes: Array<EnumDeviceType>
    var apiDesc: String? = null
    lateinit var apiMethod: EnumApiMethod
    lateinit var apiName: String
    lateinit var apiVer: EnumApiVer
    lateinit var artifactMembers: Array<EnumArtifactMemberType>
    var canBeAccessedViaDeeplink: Boolean by Delegates.notNull<Boolean>()
    var internal: Boolean by Delegates.notNull<Boolean>()
    var isDeprecated: Boolean? = null
    var logMsg: Boolean by Delegates.notNull<Boolean>()
    lateinit var module: String
    var msgClassName: String? = null
    var msgSchema: String? = null
    var msgSpec: SpecMsg? = null
    lateinit var publishes: Array<String>
    var rateLimitPerSec: Number by Delegates.notNull<Number>()
    lateinit var requiredEntAdminScopes: Array<EnumDefnAdminDoNotOptionEnt>
    lateinit var requiredPluginAdminScopes: Array<EnumDefnAdminDoNotOptionPlugin>
    lateinit var requiredStoreAdminScopes: Array<EnumDefnAdminDoNotOptionStoreItem>
    lateinit var rpcUri: String
    lateinit var scope: EnumScopeType
    lateinit var serviceName: ServiceName
    var sigClassName: String? = null
    var sigSchema: String? = null
    lateinit var sigSpec: SpecSig
    var skipEntLockCheck: Boolean? = null
    var skipEntUserAuthorization: Boolean by Delegates.notNull<Boolean>()
    var skipInputValidation: Boolean by Delegates.notNull<Boolean>()
    var sla: Number by Delegates.notNull<Number>()
    var timeout: Number by Delegates.notNull<Number>()
    lateinit var token: EnumApiToken
}
