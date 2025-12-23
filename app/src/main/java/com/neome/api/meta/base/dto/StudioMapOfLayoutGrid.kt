// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.api.meta.base.dto.StudioDtoPlaceHolder

open class StudioMapOfLayoutGrid : StudioBase()
{
  var asideDefaultLayoutId: MetaIdLayoutGrid? = null
  lateinit var keys: Array<MetaIdLayoutGrid>
  lateinit var map: Map<MetaIdLayoutGrid, StudioDtoLayoutGrid>
  var placeholder: StudioDtoPlaceHolder? = null
  var showBorderSet: Array<EnumDefnShowBorderKind>? = null
}