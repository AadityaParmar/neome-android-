// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdFormula
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoFormula

open class StudioMapOfFormula : StudioBase()
{
  var keys: Array<MetaIdFormula>? = null
  lateinit var map: Map<MetaIdFormula, StudioDtoFormula>
}