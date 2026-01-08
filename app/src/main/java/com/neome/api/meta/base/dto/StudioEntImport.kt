// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindImport
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.Symbol

interface StudioEntImport : StudioBase
{
  val description: String?
  val kind: EnumDefnKindImport?
  val metaId: MetaIdPlugin
  val modules: StudioModuleSelection?
  val name: Symbol?
}