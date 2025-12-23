// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdTranslation
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntTranslation

open class StudioEntTranslationMap : StudioBase()
{
  lateinit var keys: Array<MetaIdTranslation>
  lateinit var map: Map<MetaIdTranslation, StudioEntTranslation>
  var usePublicLibrary: Boolean? = null
}