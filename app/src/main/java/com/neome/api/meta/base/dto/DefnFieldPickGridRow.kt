// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnStudioDtoCondition
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

interface DefnFieldPickGridRow : DefnFieldEditable
{
  val copyFieldMap: Map<MetaIdField, MetaIdField>?
  val editableFieldIdSet: Array<MetaIdField>?
  val filterConditionVar: DefnStudioDtoCondition?
  val gridDisplayFieldId: MetaIdField
  val gridId: MetaIdGrid
  val gridLayoutId: MetaIdLayoutGrid?
  val showAsDropdown: Boolean?
}