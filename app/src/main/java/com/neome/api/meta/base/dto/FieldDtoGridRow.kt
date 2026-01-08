// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.dto.IFieldValue
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.RowId

interface FieldDtoGridRow
{
  val createdBy: EntUserId?
  val createdOn: String?
  val rowId: RowId
  val rowOrder: String?
  val updatedBy: EntUserId?
  val updatedOn: String?
  val valueMap: Map<MetaIdField, Any>?
}