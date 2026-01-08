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

interface StudioMapOfLayoutGrid : StudioBase
{
  val asideDefaultLayoutId: MetaIdLayoutGrid?
  val keys: Array<MetaIdLayoutGrid>
  val map: Map<MetaIdLayoutGrid, StudioDtoLayoutGrid>
  val placeholder: StudioDtoPlaceHolder?
  val showBorderSet: Array<EnumDefnShowBorderKind>?
}