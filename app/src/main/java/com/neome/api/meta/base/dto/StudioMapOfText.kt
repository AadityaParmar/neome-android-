// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm

class StudioMapOfText : StudioBase() {
    val keys: string[]
    val map: Record<string, StudioBuildArgBinderHolder>
    var sourceFormId: MetaIdForm? = null
}
