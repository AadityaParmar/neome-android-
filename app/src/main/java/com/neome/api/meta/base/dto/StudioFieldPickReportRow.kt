// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldPickReportRow : StudioFieldEditable
{
  val copyFieldMap: Map<MetaIdField, MetaIdField>?
  val editableFieldIdSet: List<MetaIdField>?
  val gridDisplayFieldId: MetaIdField?
  val reportId: MetaIdReport?
  val reportOutputFormGridId: MetaIdGrid?
  val reportOutputFormGridLayoutId: MetaIdLayoutGrid?
  val showAsDropdown: Boolean?
}