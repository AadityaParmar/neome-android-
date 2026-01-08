// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVisibilityAction
import com.neome.api.meta.base.Types.EnumDefnVisibilityActionOn
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.MetaIdVisibilityAction

interface DefnVisibilityAction
{
  val actionId: MetaIdAction?
  val compIdSet: Array<MetaIdComp>?
  val groupIdSet: Array<MetaIdGroup>?
  val layoutIdSet: Array<MetaIdLayoutForm>?
  val mappingVarId: MetaIdVar?
  val metaId: MetaIdVisibilityAction
  val source: FieldDtoArg?
  val visibilityAction: EnumDefnVisibilityAction
  val visibilityActionOn: EnumDefnVisibilityActionOn?
}