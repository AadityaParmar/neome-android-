// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindDeeplink
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.Symbol

open class DtoEntDeeplink
{
  lateinit var deepLinkId: MetaIdDeeplink
  var description: String? = null
  lateinit var kind: EnumDefnKindDeeplink
  var modules: StudioModuleSelection? = null
  lateinit var name: Symbol
}