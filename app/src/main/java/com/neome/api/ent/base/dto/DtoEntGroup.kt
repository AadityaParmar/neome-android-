// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroupActionPermissionMap
import com.neome.api.meta.base.Types.EnumDefnFreezeAvatarKind
import com.neome.api.meta.base.Types.MetaIdRole

open class DtoEntGroup
{
  lateinit var actionPermissionMap: DtoEntGroupActionPermissionMap
  var freeze: Boolean? = null
  var freezeAvatarKind: EnumDefnFreezeAvatarKind? = null
  var freezeSortName: String? = null
  var removeMessagePermissionSet: Array<MetaIdRole>? = null
}