// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindBranchIfElse
import com.neome.api.meta.base.Types.MetaIdVar

open class EntVdBranchIfElse : EntVdAutoStep() {
    var condition: StudioMapOfCondition? = null
    var conditionVarId: MetaIdVar? = null
    var option: EnumDefnKindBranchIfElse? = null
}
