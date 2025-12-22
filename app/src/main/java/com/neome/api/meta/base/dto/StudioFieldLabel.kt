// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioFieldLabel : StudioField() {
    var bgColor: StudioDtoColor? = null
    var bgColorVarId: MetaIdVar? = null
    var bold: boolean? = null
    var boldFieldId: MetaIdField? = null
    var boldVarId: MetaIdVar? = null
    var colorVarId: MetaIdVar? = null
    var italic: boolean? = null
    var italicFieldId: MetaIdField? = null
    var italicVarId: MetaIdVar? = null
    var justifyText: EnumDefnPlacement? = null
    var justifyTextVarId: MetaIdVar? = null
    var opacity: number? = null
    var opacityFieldId: MetaIdField? = null
    var opacityVarId: MetaIdVar? = null
    var strikeThrough: boolean? = null
    var strikeThroughFieldId: MetaIdField? = null
    var strikeThroughVarId: MetaIdVar? = null
    var textPattern: string? = null
    var textPatternFieldId: MetaIdField? = null
    var textPatternVarId: StudioValueVarIdText? = null
    var textSize: EnumDefnTextSize? = null
    var textSizeFieldId: MetaIdField? = null
    var textSizeVarId: MetaIdVar? = null
    var underline: boolean? = null
    var underlineFieldId: MetaIdField? = null
    var underlineVarId: MetaIdVar? = null
}
