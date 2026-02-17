// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVisibilityAction
import com.neome.api.meta.base.Types.EnumDefnVisibilityActionOn
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.MetaIdVisibilityAction
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.Symbol

interface StudioVisibilityAction : StudioBase
{
  val actionId: MetaIdAction?
  val compIdSet: List<MetaIdComp>?
  val groupIdSet: List<MetaIdGroup>?
  val layoutIdSet: List<MetaIdLayoutForm>?
  val mappingVarId: MetaIdVar?
  val metaId: MetaIdVisibilityAction
  val name: Symbol
  val source: StudioBuildArgBinder?
  val visibilityAction: EnumDefnVisibilityAction
  val visibilityActionOn: EnumDefnVisibilityActionOn?
}