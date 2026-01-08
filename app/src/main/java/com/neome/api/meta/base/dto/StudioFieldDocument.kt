// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

interface StudioFieldDocument : StudioFieldEditable
{
  val fileTypeSet: Array<EnumDefnDocFileExt>?
  val maxSize: Long?
  val maxSizeFieldId: MetaIdField?
  val maxSizeVarId: MetaIdVar?
  val showSize: Boolean?
  val showSizeFieldId: MetaIdField?
  val showSizeVarId: MetaIdVar?
}