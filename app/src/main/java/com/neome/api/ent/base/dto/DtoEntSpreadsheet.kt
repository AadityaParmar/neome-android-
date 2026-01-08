// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef
import com.neome.api.meta.base.Symbol

interface DtoEntSpreadsheet
{
  val canClear: Boolean
  val canExpire: Boolean
  val forwardRoleIdSet: Array<MetaIdRole>
  val hasPartition: Boolean
  val insertRoleIdSet: Array<MetaIdRole>
  val label: String?
  val layoutMap: DefnLayoutGridMap?
  val name: Symbol
  val removeRoleIdSet: Array<MetaIdRole>
  val sheetIdHash: String
  val spreadsheetFormId: MetaIdForm
  val spreadsheetRefTokenMap: Map<MetaIdSpreadsheetRef, String>?
  val supportOffline: Boolean
  val updateRoleIdSet: Array<MetaIdRole>
}