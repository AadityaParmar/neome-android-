// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldLabel : DefnField() {
    var bgColor: DefnDtoColor? = null
    var bgColorVar: DefnDtoColor? = null
    var bold: boolean? = null
    var boldFieldId: MetaIdField? = null
    var boldVar: boolean? = null
    var colorVar: DefnDtoColor? = null
    var italic: boolean? = null
    var italicFieldId: MetaIdField? = null
    var italicVar: boolean? = null
    var justifyText: EnumDefnPlacement? = null
    var justifyTextVar: EnumDefnPlacement? = null
    var opacity: number? = null
    var opacityFieldId: MetaIdField? = null
    var opacityVar: number? = null
    var strikeThrough: boolean? = null
    var strikeThroughFieldId: MetaIdField? = null
    var strikeThroughVar: boolean? = null
    var textPattern: string? = null
    var textPatternFieldId: MetaIdField? = null
    var textPatternVar: DefnDtoText? = null
    var textSize: EnumDefnTextSize? = null
    var textSizeFieldId: MetaIdField? = null
    var textSizeVar: EnumDefnTextSize? = null
    var underline: boolean? = null
    var underlineFieldId: MetaIdField? = null
    var underlineVar: boolean? = null
}
