// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoPlaceholder
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutGrid

open class DefnLayoutGridMap
{
  var asideDefaultLayoutId: MetaIdLayoutGrid? = null
  lateinit var keys: Array<MetaIdLayoutGrid>
  lateinit var map: Map<MetaIdLayoutGrid, DefnLayoutGrid>
  var placeholder: DefnDtoPlaceholder? = null
  var showBorderSet: Array<EnumDefnShowBorderKind>? = null
}