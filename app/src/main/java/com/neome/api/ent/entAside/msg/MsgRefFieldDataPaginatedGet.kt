// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RowId
import com.neome.api.ent.base.dto.SpreadsheetFilterComposite

open class MsgRefFieldDataPaginatedGet : Msg()
{
  var ascOrder: Boolean? = null
  var filterValue: SpreadsheetFilterComposite? = null
  lateinit var formId: MetaIdForm
  var includeFilters: Boolean? = null
  var inputFormCompositeId: MetaIdComposite? = null
  var inputFormGridRowId: RowId? = null
  lateinit var inputFormValueRaw: FormValueRaw
  var layoutSpreadsheetId: MetaIdLayoutGrid? = null
  var orderByFieldId: MetaIdField? = null
  var pageNumber: Number? = null
  var pageSize: Number? = null
  lateinit var refFieldId: MetaIdComp
  var searchText: String? = null
  var targetSpreadsheetId: MetaIdSpreadsheet? = null
}