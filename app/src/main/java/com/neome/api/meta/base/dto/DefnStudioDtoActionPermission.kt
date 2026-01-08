// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar

interface DefnStudioDtoActionPermission
{
  val deviceSizeSet: Array<EnumDefnDeviceSize>?
  val groupIdSet: Array<MetaIdGroup>?
  val hidden: Boolean?
  val inputMappingVarId: MetaIdVar?
  val menuGroup: String?
  val metaId: MetaIdAction
  val notAllowedRoleIdSet: Array<MetaIdRole>?
  val outputMappingVarId: MetaIdVar?
  val roleIdSet: Array<MetaIdRole>
  val showMessageTooltip: Boolean?
}