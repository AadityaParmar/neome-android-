// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import kotlinx.serialization.json.JsonElement
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDetails

interface StudioEntAction : StudioBase
{
  val aiInstructions: String?
  val defaultValueMap: Map<MetaIdComp, JsonElement>?
  val details: StudioDetails
  val icon: String?
  val increaseAsideWidth: Boolean?
  val kind: EnumDefnKindAction
  val metaId: MetaIdAction
  val tooltip: String?
}