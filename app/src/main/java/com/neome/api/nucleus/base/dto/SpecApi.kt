// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.Types.EnumApiMethod
import com.neome.api.nucleus.base.Types.EnumApiToken
import com.neome.api.nucleus.base.Types.EnumApiVer
import com.neome.api.nucleus.base.Types.EnumArtifactMemberType
import com.neome.api.nucleus.base.Types.EnumConnType
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionEnt
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionPlugin
import com.neome.api.meta.base.Types.EnumDefnAdminDoNotOptionStoreItem
import com.neome.api.nucleus.base.Types.EnumDeployKind
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.Types.EnumScopeType
import com.neome.api.meta.base.Types.ServiceName
import java.util.Set
import com.neome.api.nucleus.base.dto.SpecMsg
import com.neome.api.nucleus.base.dto.SpecSig

interface SpecApi
{
  val allowedConnTypes: Array<EnumConnType>
  val allowedDeployKinds: Array<EnumDeployKind>
  val allowedDeviceTypes: Array<EnumDeviceType>
  val apiDesc: String?
  val apiMethod: EnumApiMethod
  val apiName: String
  val apiVer: EnumApiVer
  val artifactMembers: Array<EnumArtifactMemberType>
  val canBeAccessedViaDeeplink: Boolean
  val internal: Boolean
  val isDeprecated: Boolean?
  val logMsg: Boolean
  val module: String
  val msgClassName: String?
  val msgSchema: String?
  val msgSpec: SpecMsg?
  val publishes: Array<String>
  val rateLimitPerSec: Long?
  val requiredEntAdminScopes: Array<EnumDefnAdminDoNotOptionEnt>
  val requiredPluginAdminScopes: Array<EnumDefnAdminDoNotOptionPlugin>
  val requiredStoreAdminScopes: Array<EnumDefnAdminDoNotOptionStoreItem>
  val rpcUri: String
  val scope: EnumScopeType
  val serviceName: ServiceName
  val sigClassName: String?
  val sigSchema: String?
  val sigSpec: SpecSig
  val skipEntLockCheck: Boolean?
  val skipEntUserAuthorization: Boolean
  val skipInputValidation: Boolean
  val sla: Long?
  val timeout: Long?
  val token: EnumApiToken
}