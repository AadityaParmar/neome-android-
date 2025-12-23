// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindRating
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioFieldRating : StudioFieldEditable() {
    var ratingKind: EnumDefnKindRating? = null
    var ratingKindVarId: MetaIdVar? = null
}
