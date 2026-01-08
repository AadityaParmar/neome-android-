// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdFooter
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.Symbol

interface StudioDtoTableFooter : StudioBase
{
  val alignment: EnumDefnPlacement?
  val bgColor: StudioDtoColor?
  val displayFieldId: MetaIdField?
  val fieldIdSet: Array<MetaIdField>
  val metaId: MetaIdFooter
  val name: Symbol?
  val showLabel: Boolean?
  val textColor: StudioDtoColor?
  val textSize: EnumDefnTextSize?
  val textStyleSet: Array<EnumDefnTextStyle>?
}