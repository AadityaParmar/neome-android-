// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoTableFooter
import com.neome.api.meta.base.Types.MetaIdFooter

interface DefnStudioMapOfTableFooter
{
  val keys: Array<MetaIdFooter>
  val map: Map<MetaIdFooter, DefnDtoTableFooter>
}