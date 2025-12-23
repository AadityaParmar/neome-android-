// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef

open class DefnSpreadsheetRef : DefnComp()
{
  lateinit var layoutSpreadsheet: DefnLayoutGrid
  var maxRecords: Number? = null
  lateinit var metaId: MetaIdSpreadsheetRef
  var refTargetFieldId: MetaIdField? = null
  var rowActionPermissionMap: DefnStudioMapOfActionPermission? = null
  lateinit var spreadsheetId: MetaIdSpreadsheet
}