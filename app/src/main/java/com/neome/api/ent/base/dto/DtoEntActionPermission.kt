// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.api.meta.base.Types.MetaIdAction

interface DtoEntActionPermission
{
  val actionId: MetaIdAction
  val deviceSizeSet: List<EnumDefnDeviceSize>?
  val hidden: Boolean?
  val menuGroup: String?
}