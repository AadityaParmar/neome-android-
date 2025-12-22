// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFormula

class StudioMapOfFormula : StudioBase() {
    var keys: MetaIdFormula[]? = null
    val map: Record<MetaIdFormula, StudioDtoFormula>
}
