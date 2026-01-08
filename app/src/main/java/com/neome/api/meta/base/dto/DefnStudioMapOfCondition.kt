// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.MetaIdVar

interface DefnStudioMapOfCondition : DefnField
{
  val excludeVarIdSet: Array<MetaIdVar>?
  val inputFormId: MetaIdForm?
  val sourceFormId: MetaIdForm
  val sourceGridId: MetaIdGrid?
  val sourcePluginId: MetaIdPlugin?
}