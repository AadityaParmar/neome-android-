// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.dto.IFieldValue
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId

interface FormValue
{
  val createdBy: EntUserId?
  val createdOn: String?
  val rowId: RowId
  val rowOrder: String?
  val updatedBy: EntUserId?
  val updatedOn: String?
  val valueMap: Map<MetaIdComp, Any>
}