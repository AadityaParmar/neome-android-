// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindImport
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioModuleSelection
import com.neome.api.meta.base.Symbol

open class StudioEntImport : StudioBase()
{
  var description: String? = null
  var kind: EnumDefnKindImport? = null
  lateinit var metaId: MetaIdPlugin
  var modules: StudioModuleSelection? = null
  var name: Symbol? = null
}