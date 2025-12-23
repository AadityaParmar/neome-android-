// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFormula
import java.util.Map

open class StudioMapOfFormula : StudioBase() {
    var keys: Array<MetaIdFormula>? = null
    lateinit var map: Map<MetaIdFormula, StudioDtoFormula>
}
