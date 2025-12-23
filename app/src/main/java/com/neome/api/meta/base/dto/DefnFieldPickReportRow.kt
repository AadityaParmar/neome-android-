// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnLayoutGrid
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdReport

open class DefnFieldPickReportRow : DefnFieldEditable()
{
  var copyFieldMap: Map<MetaIdField, MetaIdField>? = null
  var editableFieldIdSet: Array<MetaIdField>? = null
  var gridDisplayFieldId: MetaIdField? = null
  lateinit var reportId: MetaIdReport
  var reportOutputFormGridId: MetaIdGrid? = null
  var reportOutputFormGridLayout: DefnLayoutGrid? = null
  var showAsDropdown: Boolean? = null
}