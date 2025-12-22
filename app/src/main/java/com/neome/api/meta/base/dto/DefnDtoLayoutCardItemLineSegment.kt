// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField

class DefnDtoLayoutCardItemLineSegment {
    var color: DefnDtoColor? = null
    var colorFieldId: MetaIdField? = null
    var colorVar: DefnDtoColor? = null
    var line: string? = null
    var lineFieldIdSet: MetaIdField[]? = null
    var lineVar: DefnDtoText? = null
    var showLabels: boolean? = null
    var textSize: EnumDefnTextSize? = null
    var textSizeFieldId: MetaIdField? = null
    var textSizeVar: EnumDefnTextSize? = null
}
