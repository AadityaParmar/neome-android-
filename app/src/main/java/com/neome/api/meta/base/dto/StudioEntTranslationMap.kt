// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdTranslation
import java.util.Map

open class StudioEntTranslationMap : StudioBase() {
    lateinit var keys: Array<MetaIdTranslation>
    lateinit var map: Map<MetaIdTranslation, StudioEntTranslation>
    var usePublicLibrary: Boolean? = null
}
