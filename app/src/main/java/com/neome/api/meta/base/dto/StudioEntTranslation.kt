// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindTranslation
import com.neome.api.meta.base.Types.LanguageKey
import com.neome.api.meta.base.Types.MetaIdTranslation
import java.util.Map

open class StudioEntTranslation : StudioBase() {
    var doNotShareWithPublicLibrary: Boolean? = null
    lateinit var metaId: MetaIdTranslation
    var name: Symbol? = null
    lateinit var phrase: String
    var translationMap: Map<LanguageKey, String>? = null
    lateinit var type: EnumDefnKindTranslation
}
