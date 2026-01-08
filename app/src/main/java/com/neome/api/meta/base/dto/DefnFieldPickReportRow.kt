// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdReport

interface DefnFieldPickReportRow : DefnFieldEditable
{
  val copyFieldMap: Map<MetaIdField, MetaIdField>?
  val editableFieldIdSet: Array<MetaIdField>?
  val gridDisplayFieldId: MetaIdField?
  val reportId: MetaIdReport
  val reportOutputFormGridId: MetaIdGrid?
  val reportOutputFormGridLayout: DefnLayoutGrid?
  val showAsDropdown: Boolean?
}