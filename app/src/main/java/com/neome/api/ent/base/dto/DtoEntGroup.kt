// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroupActionPermissionMap
import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import com.neome.api.meta.base.Types.MetaIdRole

interface DtoEntGroup
{
  val actionPermissionMap: DtoEntGroupActionPermissionMap
  val freeze: Boolean?
  val freezeAvatarKind: EnumDefnFreezeAvatarKind?
  val freezeSortName: String?
  val removeMessagePermissionSet: List<MetaIdRole>?
}