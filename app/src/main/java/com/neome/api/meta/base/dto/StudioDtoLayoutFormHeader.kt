// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldDtoImage
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor

interface StudioDtoLayoutFormHeader : StudioBase
{
  val backgroundColor: StudioDtoColor?
  val backgroundColorVarId: MetaIdVar?
  val formLayoutId: MetaIdLayoutForm?
  val headerImage: FieldDtoImage?
  val headerImageHeight: Long?
  val headerImageVarId: MetaIdVar?
  val hyperlinkVarIdSet: List<MetaIdVar>?
  val showEnterprise: Boolean?
  val showSeparator: Boolean?
  val textColor: StudioDtoColor?
  val textColorVarId: MetaIdVar?
}