// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.MetaIdAction

interface DefnStudioBuildActionPermission : DefnField
{
  val allowGrouping: Boolean?
  val allowShowMessageTooltip: Boolean?
  val allowSystemRoles: Boolean?
  val includeActionIdSet: Array<MetaIdAction>?
  val includeOptionMap: DefnStudioMapOfDtoOption?
  val isGroupAction: Boolean?
}