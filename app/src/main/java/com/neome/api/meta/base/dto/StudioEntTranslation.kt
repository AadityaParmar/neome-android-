// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindTranslation
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MetaIdTranslation

class StudioEntTranslation : StudioBase() {
    var doNotShareWithPublicLibrary: boolean? = null
    val metaId: MetaIdTranslation
    var name: Symbol? = null
    val phrase: string
    var translationMap: Record<LanguageKey, string>? = null
    val type: EnumDefnKindTranslation
}
