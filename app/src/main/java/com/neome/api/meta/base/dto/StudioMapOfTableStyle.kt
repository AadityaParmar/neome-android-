// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdTableStyle
import java.util.Map

open class StudioMapOfTableStyle : StudioBase() {
    lateinit var keys: Array<MetaIdTableStyle>
    lateinit var map: Map<MetaIdTableStyle, StudioDtoTableStyle>
}
