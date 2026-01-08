// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdLayoutForm

interface DefnLayoutFormFooter
{
  val footerImage: FieldDtoImage?
  val footerImageHeight: Long?
  val footerImageVar: FieldDtoImage?
  val formLayoutId: MetaIdLayoutForm?
  val showSeparator: Boolean?
}