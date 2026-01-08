// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntAction
import com.neome.api.ent.base.dto.DtoEntActionPermission
import com.google.gson.JsonElement
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DtoEntActionSpreadsheetEditor : DtoEntAction
{
  val actionPermissionMap: Map<MetaIdAction, DtoEntActionPermission>?
  val bulkInsertRoleSet: Array<MetaIdRole>?
  val bulkUpdateFieldIdSet: Array<MetaIdField>?
  val bulkUpdateRoleSet: Array<MetaIdRole>?
  val defaultValueMap: Map<MetaIdComp, Any>?
  val doNotOpenAside: Boolean?
  val inputFormId: MetaIdForm?
  val layoutSpreadsheetId: MetaIdLayoutGrid
  val readOnly: Boolean?
  val sendMessageToGroupId: MetaIdGroup?
  val spreadsheetFormId: MetaIdForm
  val spreadsheetId: MetaIdSpreadsheet
}