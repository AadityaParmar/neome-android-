// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioDtoLayoutFormWatermark : StudioBase() {
    var bgImage: FieldDtoImage? = null
    var bgImageHorizontalPosition: EnumDefnContentAlignment? = null
    var bgImageVarId: MetaIdVar? = null
    var bgImageVerticalPosition: EnumDefnContentAlignment? = null
    var textOpacityVarId: MetaIdVar? = null
    var textPatternVarId: StudioValueVarIdText? = null
    var textPositionVarId: MetaIdVar? = null
    var textSizeVarId: MetaIdVar? = null
}
