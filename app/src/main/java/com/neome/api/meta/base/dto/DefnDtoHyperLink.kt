// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.Types.EnumDefnKindHyperlink
import com.neome.api.meta.base.Types.MetaIdHyperlink

open class DefnDtoHyperLink
{
  var color: DefnDtoColor? = null
  var colorVar: DefnDtoColor? = null
  var displayText: String? = null
  var kind: EnumDefnKindHyperlink? = null
  lateinit var metaId: MetaIdHyperlink
  var value: String? = null
}