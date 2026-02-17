// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.RowId

interface DefnGrid : DefnComp
{
  val actionPermissionMap: DefnStudioMapOfActionPermission?
  val fieldIdSet: List<MetaIdField>?
  val hideAddBtn: Boolean?
  val isPickMany: Boolean?
  val layoutGridMap: DefnLayoutGridMap?
  val maxRows: Long?
  val maxRowsFieldId: MetaIdField?
  val maxRowsVar: Long?
  val metaId: MetaIdGrid
  val minRows: Long?
  val minRowsFieldId: MetaIdField?
  val minRowsVar: Long?
  val pickedRowIdSet: List<RowId>?
  val propertyEditorLabel: String?
  val rowActionPermissionMap: DefnStudioMapOfActionPermission?
  val showAllRowsFieldId: MetaIdField?
  val showExpand: Boolean?
}