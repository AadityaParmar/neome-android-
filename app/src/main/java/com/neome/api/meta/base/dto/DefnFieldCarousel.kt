// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoMedia
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.Types.EnumDefnThemeImageCorner
import com.neome.api.meta.base.Types.MetaIdField

interface DefnFieldCarousel : DefnField
{
  val borderRadius: List<Long>?
  val fieldIdSet: List<MetaIdField>?
  val height: Long?
  val imageCornerVar: EnumDefnThemeImageCorner?
  val mediaVarSet: List<DefnDtoMedia>?
  val showAsCard: Boolean?
  val showMediaPlaceholder: Boolean?
  val width: Long?
}