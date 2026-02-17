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
import com.neome.api.nucleus.base.dto.SpecMsg
import com.neome.api.nucleus.base.dto.SpecSig

interface SpecApi
{
  val allowedConnTypes: List<EnumConnType>
  val allowedDeployKinds: List<EnumDeployKind>
  val allowedDeviceTypes: List<EnumDeviceType>
  val apiDesc: String?
  val apiMethod: EnumApiMethod
  val apiName: String
  val apiVer: EnumApiVer
  val artifactMembers: Set<EnumArtifactMemberType>
  val canBeAccessedViaDeeplink: Boolean
  val internal: Boolean
  val isDeprecated: Boolean?
  val logMsg: Boolean
  val module: String
  val msgClassName: String?
  val msgSchema: String?
  val msgSpec: SpecMsg?
  val publishes: List<String>
  val rateLimitPerSec: Long
  val requiredEntAdminScopes: List<EnumDefnAdminDoNotOptionEnt>
  val requiredPluginAdminScopes: List<EnumDefnAdminDoNotOptionPlugin>
  val requiredStoreAdminScopes: List<EnumDefnAdminDoNotOptionStoreItem>
  val rpcUri: String
  val scope: EnumScopeType
  val serviceName: ServiceName
  val sigClassName: String?
  val sigSchema: String?
  val sigSpec: SpecSig
  val skipEntLockCheck: Boolean?
  val skipEntUserAuthorization: Boolean
  val skipInputValidation: Boolean
  val sla: Long
  val timeout: Long
  val token: EnumApiToken
}