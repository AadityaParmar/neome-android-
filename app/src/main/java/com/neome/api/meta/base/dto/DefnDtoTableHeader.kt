// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdHeader

interface DefnDtoTableHeader
{
  val bgColor: DefnDtoColor?
  val displayText: String
  val fieldIdSet: Array<MetaIdField>
  val metaId: MetaIdHeader
  val textColor: DefnDtoColor?
  val textSize: EnumDefnTextSize?
  val textStyleSet: Array<EnumDefnTextStyle>?
}