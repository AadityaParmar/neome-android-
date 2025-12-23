// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.Types.EnumDefnKindRating

open class DefnFieldRating : DefnFieldEditable() {
    var ratingKind: EnumDefnKindRating? = null
    var ratingKindVar: EnumDefnKindRating? = null
}
