// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindDeeplink
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.Symbol

interface DtoEntDeeplink
{
  val deepLinkId: MetaIdDeeplink
  val description: String?
  val kind: EnumDefnKindDeeplink
  val modules: StudioModuleSelection?
  val name: Symbol
}