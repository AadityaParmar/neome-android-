// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdMapping
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.Symbol

interface StudioDtoMappingField : StudioBase
{
  val from: StudioBuildArgBinder
  val metaId: MetaIdMapping
  val name: Symbol?
  val primary: Boolean?
  val to: MetaIdField
}