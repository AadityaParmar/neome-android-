// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase

interface StudioDtoLayoutFormFooter : StudioBase
{
  val footerImage: FieldDtoImage?
  val footerImageHeight: Long?
  val footerImageVarId: MetaIdVar?
  val formLayoutId: MetaIdLayoutForm?
  val showSeparator: Boolean?
}