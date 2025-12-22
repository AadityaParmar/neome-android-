// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeImageCorner
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldCarousel : DefnField() {
    var borderRadius: number[]? = null
    var fieldIdSet: MetaIdField[]? = null
    var height: number? = null
    var imageCornerVar: EnumDefnThemeImageCorner? = null
    var mediaVarSet: DefnDtoMedia[]? = null
    var showAsCard: boolean? = null
    var showMediaPlaceholder: boolean? = null
    var width: number? = null
}
