// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField

interface DefnDtoLayoutCardItemLineSegment {
    val color: DefnDtoColor?
    val colorFieldId: MetaIdField?
    val colorVar: DefnDtoColor?
    val line: String?
    val lineFieldIdSet: List<MetaIdField>?
    val lineVar: DefnDtoText?
    val showLabels: Boolean?
    val textSize: EnumDefnTextSize?
    val textSizeFieldId: MetaIdField?
    val textSizeVar: EnumDefnTextSize?
}
