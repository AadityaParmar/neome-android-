// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdFormula

class StudioDtoFormula : StudioBase() {
    val assignToFieldId: MetaIdField
    var conditionVarId: StudioValueVarIdCondition? = null
    var formula: StudioValueCodeJavascript? = null
    val metaId: MetaIdFormula
    var name: Symbol? = null
}
