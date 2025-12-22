// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioDtoLayoutCardItemLineSegment : StudioBase() {
    var color: StudioDtoColor? = null
    var colorFieldId: MetaIdField? = null
    var colorVarId: MetaIdVar? = null
    var line: string? = null
    var lineFieldIdSet: MetaIdField[]? = null
    var lineVarId: StudioValueVarIdText? = null
    var showLabels: boolean? = null
    var textSize: EnumDefnTextSize? = null
    var textSizeFieldId: MetaIdField? = null
    var textSizeVarId: MetaIdVar? = null
}
