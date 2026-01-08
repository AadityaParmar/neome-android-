// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.Symbol

interface StudioEntAutomation : StudioBase
{
  val active: Boolean?
  val description: String?
  val kind: EnumDefnKindAutomation
  val metaId: MetaIdAutomation
  val modules: StudioModuleSelection?
  val name: Symbol
  val secondary: String?
}