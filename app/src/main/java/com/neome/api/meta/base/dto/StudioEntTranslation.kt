// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindTranslation
import com.neome.api.meta.base.Types.LanguageKey
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdTranslation
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.Symbol

interface StudioEntTranslation : StudioBase
{
  val doNotShareWithPublicLibrary: Boolean?
  val metaId: MetaIdTranslation
  val name: Symbol?
  val phrase: String
  val translationMap: Map<LanguageKey, String>?
  val type: EnumDefnKindTranslation
}