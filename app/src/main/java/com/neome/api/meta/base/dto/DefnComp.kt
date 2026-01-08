// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Symbol

interface DefnComp
{
  val disabled: Boolean?
  val disabledFieldId: MetaIdField?
  val disabledRoleIdSet: Array<MetaIdRole>?
  val disabledVar: Boolean?
  val hidden: Boolean?
  val hideDirtyIndicator: Boolean?
  val invisible: Boolean?
  val label: String?
  val maxWidth: Long?
  val name: Symbol
  val pb: Long?
  val permissionMatrix: DefnDtoPermissionMatrix?
  val pl: Long?
  val pr: Long?
  val pt: Long?
  val readOnly: Boolean?
  val type: EnumDefnCompType
}