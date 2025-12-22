// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeImageRenderingMode
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioDtoLayoutCardItem : StudioBase() {
    var fifthLine: StudioDtoLayoutCardItemLine? = null
    var firstLine: StudioDtoLayoutCardItemLine? = null
    var fourthLine: StudioDtoLayoutCardItemLine? = null
    var imageBackgroundColor: StudioDtoColor? = null
    var imageCornerVarId: MetaIdVar? = null
    var imageHeight: number? = null
    var imageHeightVarId: MetaIdVar? = null
    var imageRenderingMode: EnumDefnThemeImageRenderingMode? = null
    var imageWidth: number? = null
    var imageWidthVarId: MetaIdVar? = null
    var mediaFieldIdSet: MetaIdField[]? = null
    var mediaVarIdSet: MetaIdVar[]? = null
    var secondLine: StudioDtoLayoutCardItemLine? = null
    var thirdLine: StudioDtoLayoutCardItemLine? = null
}
