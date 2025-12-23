// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDocFileExt

open class StudioSetOfDocFileExt : StudioBase() {
    lateinit var valueSet: Array<EnumDefnDocFileExt>
}
