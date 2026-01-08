// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.dto.StudioDtoMapping

interface StudioVarValueMapping : StudioDtoMapping
{
  val fromFormId: MetaIdForm?
  val fromPluginId: MetaIdPlugin?
  val toFormId: MetaIdForm?
  val toPluginId: MetaIdPlugin?
}