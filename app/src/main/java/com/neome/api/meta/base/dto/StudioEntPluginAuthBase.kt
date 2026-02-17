// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnPluginAuthMethod
import com.neome.api.meta.base.Types.MetaIdAuthMethod
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.Symbol

interface StudioEntPluginAuthBase : StudioBase
{
  val description: String?
  val kind: EnumDefnPluginAuthMethod
  val metaId: MetaIdAuthMethod
  val modules: StudioModuleSelection?
  val name: Symbol
}