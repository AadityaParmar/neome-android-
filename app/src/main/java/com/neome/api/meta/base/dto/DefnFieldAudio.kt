// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnAudioFormat
import com.neome.api.meta.base.Types.MetaIdField

class DefnFieldAudio : DefnFieldEditable() {
    var audioFormatType: EnumDefnAudioFormat? = null
    var maxSize: number? = null
    var maxSizeFieldId: MetaIdField? = null
    var maxSizeVar: number? = null
}
