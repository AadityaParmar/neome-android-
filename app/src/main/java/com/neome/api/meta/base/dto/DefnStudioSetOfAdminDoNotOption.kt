// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnAdminPermissionType

open class DefnStudioSetOfAdminDoNotOption : DefnField()
{
  var adminPermissionType: EnumDefnAdminPermissionType? = null
}