// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnVideoFormat
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioFieldEditable

open class StudioFieldVideo : StudioFieldEditable()
{
  var allowPickVideo: Boolean? = null
  var maxSize: Number? = null
  var maxSizeFieldId: MetaIdField? = null
  var maxSizeVarId: MetaIdVar? = null
  var showPreview: Boolean? = null
  var showPreviewFieldId: MetaIdField? = null
  var showPreviewVarId: MetaIdVar? = null
  var showSize: Boolean? = null
  var showSizeFieldId: MetaIdField? = null
  var showSizeVarId: MetaIdVar? = null
  var videoFormatType: EnumDefnVideoFormat? = null
}