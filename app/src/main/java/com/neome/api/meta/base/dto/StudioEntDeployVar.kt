// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioBase

interface StudioEntDeployVar : StudioBase
{
  val kind: EnumStudioVarKind
  val metaId: MetaIdVar
  val varValue: JsonElement?
}