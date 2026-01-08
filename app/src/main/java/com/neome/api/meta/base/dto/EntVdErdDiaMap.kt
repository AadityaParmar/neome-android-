// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdErdDia
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdVdErdDia
import com.neome.api.meta.base.dto.StudioBase

interface EntVdErdDiaMap : StudioBase
{
  val keys: Array<MetaIdVdErdDia>
  val map: Map<MetaIdVdErdDia, EntVdErdDia>
}