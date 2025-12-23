// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPermission
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdRole

open class DefnDtoPermissionMatrix
{
  var defaultPermission: EnumDefnPermission? = null
  var keys: Array<MetaIdRole>? = null
  var map: Map<MetaIdRole, EnumDefnPermission>? = null
}