// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdTranslation

interface StudioEntTranslationMap : StudioBase {
    val keys: List<MetaIdTranslation>
    val map: Map<MetaIdTranslation, StudioEntTranslation>
    val usePublicLibrary: Boolean?
}
