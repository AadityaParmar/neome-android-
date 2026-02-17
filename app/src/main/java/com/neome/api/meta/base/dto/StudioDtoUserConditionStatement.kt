// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindSetOfUser
import com.neome.api.meta.base.Types.EnumDefnUserContext
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoUserConditionStatement : StudioBase
{
  val derivedRoleIdSet: List<MetaIdRole>?
  val fieldIdSet: List<MetaIdField>?
  val kind: EnumDefnKindSetOfUser?
  val roleIdSet: List<MetaIdRole>?
  val userContextSet: List<EnumDefnUserContext>?
}