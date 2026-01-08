// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind

interface DtoEntGroupFreezeSetting
{
  val freeze: Boolean?
  val freezeAvatarKind: EnumDefnFreezeAvatarKind?
  val freezeSortName: String?
}