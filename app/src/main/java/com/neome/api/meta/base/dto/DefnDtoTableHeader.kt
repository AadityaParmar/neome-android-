// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnTextStyle
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdHeader

open class DefnDtoTableHeader
{
  var bgColor: DefnDtoColor? = null
  lateinit var displayText: String
  lateinit var fieldIdSet: Array<MetaIdField>
  lateinit var metaId: MetaIdHeader
  var textColor: DefnDtoColor? = null
  var textSize: EnumDefnTextSize? = null
  var textStyleSet: Array<EnumDefnTextStyle>? = null
}