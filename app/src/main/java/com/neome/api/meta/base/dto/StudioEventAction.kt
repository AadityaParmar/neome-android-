// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindEventAction
import com.neome.api.meta.base.Types.EnumDefnKindEventActionOn
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdFormEventAction
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioValueCodeJavascript
import com.neome.api.meta.base.Symbol

interface StudioEventAction : StudioBase
{
  val actionId: MetaIdAction?
  val actionOn: EnumDefnKindEventActionOn?
  val compIdSet: List<MetaIdComp>?
  val formula: StudioValueCodeJavascript?
  val groupIdSet: List<MetaIdGroup>?
  val kind: EnumDefnKindEventAction
  val layoutIdSet: List<MetaIdLayoutForm>?
  val mappingVarId: MetaIdVar?
  val metaId: MetaIdFormEventAction
  val name: Symbol
  val source: StudioBuildArgBinder?
}