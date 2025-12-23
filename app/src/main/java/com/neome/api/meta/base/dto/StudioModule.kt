// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdModule
import com.neome.api.meta.base.dto.StudioBase

open class StudioModule : StudioBase()
{
  lateinit var metaId: MetaIdModule
  lateinit var name: String
}