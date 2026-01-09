package com.neome.core.common.serializer.api.nucleus.base.dto

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
import com.neome.api.nucleus.base.dto.SpecApi
import com.neome.api.nucleus.base.dto.SpecMsg
import com.neome.api.nucleus.base.dto.SpecSig
import kotlinx.serialization.Serializable


@Serializable
data class SpecApiData(
    override val allowedConnTypes: Array<EnumConnType>,
    override val allowedDeployKinds: Array<EnumDeployKind>,
    override val allowedDeviceTypes: Array<EnumDeviceType>,
    override val apiDesc: String? = null,
    override val apiMethod: EnumApiMethod,
    override val apiName: String,
    override val apiVer: EnumApiVer,
    override val artifactMembers: Array<EnumArtifactMemberType>,
    override val canBeAccessedViaDeeplink: Boolean,
    override val internal: Boolean,
    override val isDeprecated: Boolean? = null,
    override val logMsg: Boolean,
    override val module: String,
    override val msgClassName: String? = null,
    override val msgSchema: String? = null,
    override val msgSpec: SpecMsg? = null,
    override val publishes: Array<String>,
    override val rateLimitPerSec: Long? = null,
    override val requiredEntAdminScopes: Array<EnumDefnAdminDoNotOptionEnt>,
    override val requiredPluginAdminScopes: Array<EnumDefnAdminDoNotOptionPlugin>,
    override val requiredStoreAdminScopes: Array<EnumDefnAdminDoNotOptionStoreItem>,
    override val rpcUri: String,
    override val scope: EnumScopeType,
    override val serviceName: ServiceName,
    override val sigClassName: String? = null,
    override val sigSchema: String? = null,
    override val sigSpec: SpecSig,
    override val skipEntLockCheck: Boolean? = null,
    override val skipEntUserAuthorization: Boolean,
    override val skipInputValidation: Boolean,
    override val sla: Long? = null,
    override val timeout: Long? = null,
    override val token: EnumApiToken
) : SpecApi
