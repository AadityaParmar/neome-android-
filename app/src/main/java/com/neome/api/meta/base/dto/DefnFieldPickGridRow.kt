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

open class DefnFieldPickGridRow : DefnFieldEditable()
{
  var copyFieldMap: Map<MetaIdField, MetaIdField>? = null
  var editableFieldIdSet: Array<MetaIdField>? = null
  var filterConditionVar: DefnStudioDtoCondition? = null
  lateinit var gridDisplayFieldId: MetaIdField
  lateinit var gridId: MetaIdGrid
  var gridLayoutId: MetaIdLayoutGrid? = null
  var showAsDropdown: Boolean? = null
}