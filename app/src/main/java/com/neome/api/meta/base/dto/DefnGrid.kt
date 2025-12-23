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

open class DefnGrid : DefnComp()
{
  var actionPermissionMap: DefnStudioMapOfActionPermission? = null
  var fieldIdSet: Array<MetaIdField>? = null
  var hideAddBtn: Boolean? = null
  var isPickMany: Boolean? = null
  var layoutGridMap: DefnLayoutGridMap? = null
  var maxRows: Number? = null
  var maxRowsVar: Number? = null
  lateinit var metaId: MetaIdGrid
  var minRows: Number? = null
  var minRowsVar: Number? = null
  var pickedRowIdSet: Array<RowId>? = null
  var propertyEditorLabel: String? = null
  var rowActionPermissionMap: DefnStudioMapOfActionPermission? = null
  var showAllRowsFieldId: MetaIdField? = null
  var showExpand: Boolean? = null
}