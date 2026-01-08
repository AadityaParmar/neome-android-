// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldImage : StudioFieldEditable
{
  val defaultImage: FieldDtoImage?
  val defaultImageFieldId: MetaIdField?
  val defaultImageVarId: MetaIdVar?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVarId: MetaIdVar?
  val showLabel: Boolean?
  val showLabelFieldId: MetaIdField?
  val showLabelVarId: MetaIdVar?
  val showPreview: Boolean?
  val showPreviewFieldId: MetaIdField?
  val showPreviewVarId: MetaIdVar?
  val showSize: Boolean?
  val showSizeFieldId: MetaIdField?
  val showSizeVarId: MetaIdVar?
}