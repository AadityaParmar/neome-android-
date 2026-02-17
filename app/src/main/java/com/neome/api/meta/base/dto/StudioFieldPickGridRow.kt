// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.dto.StudioFieldEditable
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioFieldPickGridRow : StudioFieldEditable
{
  val copyFieldMap: Map<MetaIdField, MetaIdField>?
  val editableFieldIdSet: List<MetaIdField>?
  val filterConditionVarId: StudioValueVarIdCondition?
  val gridDisplayFieldId: MetaIdField?
  val gridId: MetaIdGrid?
  val gridLayoutId: MetaIdLayoutGrid?
  val showAsDropdown: Boolean?
}