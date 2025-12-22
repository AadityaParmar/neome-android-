// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdTranslation

class StudioEntTranslationMap : StudioBase() {
    val keys: MetaIdTranslation[]
    val map: Record<MetaIdTranslation, StudioEntTranslation>
    var usePublicLibrary: boolean? = null
}
