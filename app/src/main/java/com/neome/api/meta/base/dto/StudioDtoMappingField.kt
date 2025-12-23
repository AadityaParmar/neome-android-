// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdMapping
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.Symbol

open class StudioDtoMappingField : StudioBase()
{
  lateinit var from: StudioBuildArgBinder
  lateinit var metaId: MetaIdMapping
  var name: Symbol? = null
  var primary: Boolean? = null
  lateinit var to: MetaIdField
}