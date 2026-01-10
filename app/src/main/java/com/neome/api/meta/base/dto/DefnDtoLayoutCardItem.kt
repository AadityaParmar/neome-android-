// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnThemeImageCorner
import com.neome.api.meta.base.Types.EnumDefnThemeImageRenderingMode
import com.neome.api.meta.base.Types.MetaIdField

interface DefnDtoLayoutCardItem {
    val fifthLine: DefnDtoLayoutCardItemLine?
    val firstLine: DefnDtoLayoutCardItemLine?
    val fourthLine: DefnDtoLayoutCardItemLine?
    val imageBackgroundColor: DefnDtoColor?
    val imageCornerVar: EnumDefnThemeImageCorner?
    val imageHeight: Long?
    val imageHeightVar: Long?
    val imageRenderingMode: EnumDefnThemeImageRenderingMode?
    val imageWidth: Long?
    val imageWidthVar: Long?
    val mediaFieldIdSet: List<MetaIdField>?
    val mediaVarSet: List<DefnDtoMedia>?
    val secondLine: DefnDtoLayoutCardItemLine?
    val thirdLine: DefnDtoLayoutCardItemLine?
}
