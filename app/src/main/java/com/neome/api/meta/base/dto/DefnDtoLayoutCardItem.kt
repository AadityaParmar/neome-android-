// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeImageCorner
import com.neome.api.meta.base.Types.EnumDefnThemeImageRenderingMode
import com.neome.api.meta.base.Types.MetaIdField

open class DefnDtoLayoutCardItem {
    var fifthLine: DefnDtoLayoutCardItemLine? = null
    var firstLine: DefnDtoLayoutCardItemLine? = null
    var fourthLine: DefnDtoLayoutCardItemLine? = null
    var imageBackgroundColor: DefnDtoColor? = null
    var imageCornerVar: EnumDefnThemeImageCorner? = null
    var imageHeight: Number? = null
    var imageHeightVar: Number? = null
    var imageRenderingMode: EnumDefnThemeImageRenderingMode? = null
    var imageWidth: Number? = null
    var imageWidthVar: Number? = null
    var mediaFieldIdSet: Array<MetaIdField>? = null
    var mediaVarSet: Array<DefnDtoMedia>? = null
    var secondLine: DefnDtoLayoutCardItemLine? = null
    var thirdLine: DefnDtoLayoutCardItemLine? = null
}
