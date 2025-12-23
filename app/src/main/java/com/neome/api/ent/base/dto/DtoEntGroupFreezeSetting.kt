// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind

open class DtoEntGroupFreezeSetting
{
  var freeze: Boolean? = null
  var freezeAvatarKind: EnumDefnFreezeAvatarKind? = null
  var freezeSortName: String? = null
}