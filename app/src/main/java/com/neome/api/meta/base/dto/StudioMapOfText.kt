// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import java.util.Map

open class StudioMapOfText : StudioBase() {
    lateinit var keys: Array<String>
    lateinit var map: Map<String, StudioBuildArgBinderHolder>
    var sourceFormId: MetaIdForm? = null
}
