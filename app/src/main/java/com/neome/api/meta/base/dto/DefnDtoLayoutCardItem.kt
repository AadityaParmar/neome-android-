// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeImageCorner
import com.neome.api.meta.base.Types.EnumDefnThemeImageRenderingMode
import com.neome.api.meta.base.Types.MetaIdField

class DefnDtoLayoutCardItem {
    var fifthLine: DefnDtoLayoutCardItemLine? = null
    var firstLine: DefnDtoLayoutCardItemLine? = null
    var fourthLine: DefnDtoLayoutCardItemLine? = null
    var imageBackgroundColor: DefnDtoColor? = null
    var imageCornerVar: EnumDefnThemeImageCorner? = null
    var imageHeight: number? = null
    var imageHeightVar: number? = null
    var imageRenderingMode: EnumDefnThemeImageRenderingMode? = null
    var imageWidth: number? = null
    var imageWidthVar: number? = null
    var mediaFieldIdSet: MetaIdField[]? = null
    var mediaVarSet: DefnDtoMedia[]? = null
    var secondLine: DefnDtoLayoutCardItemLine? = null
    var thirdLine: DefnDtoLayoutCardItemLine? = null
}
