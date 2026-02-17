// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldDocument : DefnFieldEditable
{
  val disablePreview: Boolean?
  val fileTypeSet: List<EnumDefnDocFileExt>?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVar: Long?
  val showSize: Boolean?
  val showSizeFieldId: MetaIdField?
  val showSizeVar: Boolean?
}