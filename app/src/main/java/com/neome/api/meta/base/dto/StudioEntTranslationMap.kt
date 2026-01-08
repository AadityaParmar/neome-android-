// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdTranslation
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntTranslation

interface StudioEntTranslationMap : StudioBase
{
  val keys: Array<MetaIdTranslation>
  val map: Map<MetaIdTranslation, StudioEntTranslation>
  val usePublicLibrary: Boolean?
}