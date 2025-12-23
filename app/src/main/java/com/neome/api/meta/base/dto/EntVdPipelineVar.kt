// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.Symbol

open class EntVdPipelineVar : StudioBase()
{
  lateinit var metaId: MetaIdPipelineVar
  lateinit var name: Symbol
  var variableForm: FormRefKey? = null
}