// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldImage : DefnFieldEditable
{
  val defaultImage: FieldDtoImage?
  val defaultImageFieldId: MetaIdField?
  val defaultImageVar: FieldDtoImage?
  val flexWidth: Boolean?
  val height: Long?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVar: Long?
  val showLabel: Boolean?
  val showLabelFieldId: MetaIdField?
  val showLabelVar: Boolean?
  val showPreview: Boolean?
  val showPreviewFieldId: MetaIdField?
  val showPreviewVar: Boolean?
  val showSize: Boolean?
  val showSizeFieldId: MetaIdField?
  val showSizeVar: Boolean?
}