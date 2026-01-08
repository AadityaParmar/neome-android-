// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.EnumDefnThemePickMultiVariant
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole

interface DefnFieldSetOfRole : DefnFieldEditable
{
  val allowSystemRoles: Boolean?
  val callerRoleMap: DefnStudioMapOfDtoOption?
  val defaultRoleFieldId: MetaIdField?
  val defaultRoleIdSet: Array<MetaIdRole>?
  val excludeRoleIdSet: Array<MetaIdRole>?
  val filterRoleIdSet: Array<MetaIdRole>?
  val includeOptionMap: DefnStudioMapOfDtoOption?
  val pageSize: Long?
  val showAs: EnumDefnThemePickMultiVariant?
}