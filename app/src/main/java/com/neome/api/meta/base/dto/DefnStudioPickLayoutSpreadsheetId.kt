// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DefnStudioPickLayoutSpreadsheetId : DefnFieldEditable
{
  val excludeLayoutSpreadsheetIdSet: Array<MetaIdLayoutGrid>?
  val filterLayoutKindSet: Array<EnumDefnLayoutGridKind>?
  val showAlias: Boolean?
  val spreadsheetId: MetaIdSpreadsheet
}