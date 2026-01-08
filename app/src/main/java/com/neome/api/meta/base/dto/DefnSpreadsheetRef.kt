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

interface DefnSpreadsheetRef : DefnComp
{
  val layoutSpreadsheet: DefnLayoutGrid
  val maxRecords: Long?
  val metaId: MetaIdSpreadsheetRef
  val refTargetFieldId: MetaIdField?
  val rowActionPermissionMap: DefnStudioMapOfActionPermission?
  val spreadsheetId: MetaIdSpreadsheet
}