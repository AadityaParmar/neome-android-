// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioMapOfCondition

interface StudioVarValueCondition : StudioBase
{
  val inputFormId: MetaIdForm?
  val inputPluginId: MetaIdPlugin?
  val node: StudioMapOfCondition?
  val sourceFormId: MetaIdForm?
  val sourceGridId: MetaIdGrid?
  val sourcePluginId: MetaIdPlugin?
}