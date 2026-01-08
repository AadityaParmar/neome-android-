// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVideoFormat
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldVideo : StudioFieldEditable
{
  val allowPickVideo: Boolean?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVarId: MetaIdVar?
  val showPreview: Boolean?
  val showPreviewFieldId: MetaIdField?
  val showPreviewVarId: MetaIdVar?
  val showSize: Boolean?
  val showSizeFieldId: MetaIdField?
  val showSizeVarId: MetaIdVar?
  val videoFormatType: EnumDefnVideoFormat?
}