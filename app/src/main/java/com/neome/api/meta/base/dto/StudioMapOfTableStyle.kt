// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdTableStyle

class StudioMapOfTableStyle : StudioBase() {
    val keys: MetaIdTableStyle[]
    val map: Record<MetaIdTableStyle, StudioDtoTableStyle>
}
