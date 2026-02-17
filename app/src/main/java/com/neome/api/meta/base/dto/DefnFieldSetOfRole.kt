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
  val defaultRoleIdSet: List<MetaIdRole>?
  val excludeRoleIdSet: List<MetaIdRole>?
  val filterRoleIdSet: List<MetaIdRole>?
  val includeOptionMap: DefnStudioMapOfDtoOption?
  val pageSize: Long?
  val showAs: EnumDefnThemePickMultiVariant?
}