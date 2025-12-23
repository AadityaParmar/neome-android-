// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindSetOfUser
import com.neome.api.meta.base.Types.EnumDefnUserContext
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioBase

open class StudioDtoUserConditionStatement : StudioBase()
{
  var derivedRoleIdSet: Array<MetaIdRole>? = null
  var fieldIdSet: Array<MetaIdField>? = null
  var kind: EnumDefnKindSetOfUser? = null
  var roleIdSet: Array<MetaIdRole>? = null
  var userContextSet: Array<EnumDefnUserContext>? = null
}