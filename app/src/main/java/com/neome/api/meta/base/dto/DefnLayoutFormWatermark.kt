// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnContentAlignment
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize

open class DefnLayoutFormWatermark {
    var bgImage: FieldDtoImage? = null
    var bgImageHorizontalPosition: EnumDefnContentAlignment? = null
    var bgImageVar: FieldDtoImage? = null
    var bgImageVerticalPosition: EnumDefnContentAlignment? = null
    var textOpacityVar: Number? = null
    var textPatternVar: DefnDtoText? = null
    var textPositionVar: EnumDefnPlacement? = null
    var textSizeVar: EnumDefnTextSize? = null
}
