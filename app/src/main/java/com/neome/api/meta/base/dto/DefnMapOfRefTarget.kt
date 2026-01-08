// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoRefTarget
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

interface DefnMapOfRefTarget
{
  val keys: Array<MetaIdSpreadsheet>
  val map: Map<MetaIdSpreadsheet, DefnDtoRefTarget>
}