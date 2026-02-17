// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix

interface StudioComp : StudioBase
{
  val aiInstructions: String?
  val details: StudioDetails
  val disabled: Boolean?
  val disabledFieldId: MetaIdField?
  val disabledRoleIdSet: List<MetaIdRole>?
  val disabledVarId: MetaIdVar?
  val permissionMatrix: StudioDtoPermissionMatrix?
  val type: EnumStudioCompType?
}