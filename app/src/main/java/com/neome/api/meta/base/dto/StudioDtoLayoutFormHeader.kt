// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor

open class StudioDtoLayoutFormHeader : StudioBase()
{
  var backgroundColor: StudioDtoColor? = null
  var backgroundColorVarId: MetaIdVar? = null
  var formLayoutId: MetaIdLayoutForm? = null
  var headerImage: FieldDtoImage? = null
  var headerImageHeight: Number? = null
  var headerImageVarId: MetaIdVar? = null
  var hyperlinkVarIdSet: Array<MetaIdVar>? = null
  var showEnterprise: Boolean? = null
  var showSeparator: Boolean? = null
  var textColor: StudioDtoColor? = null
  var textColorVarId: MetaIdVar? = null
}