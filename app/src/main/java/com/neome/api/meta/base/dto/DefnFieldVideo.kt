// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnVideoFormat
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldVideo : DefnFieldEditable
{
  val allowPickVideo: Boolean?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVar: Long?
  val showPreview: Boolean?
  val showPreviewFieldId: MetaIdField?
  val showPreviewVar: Boolean?
  val showSize: Boolean?
  val showSizeFieldId: MetaIdField?
  val showSizeVar: Boolean?
  val videoFormatType: EnumDefnVideoFormat?
}