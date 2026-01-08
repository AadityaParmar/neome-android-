// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoGuaranteedRequest
import com.neome.api.ent.base.dto.DtoPluginApiRequestPayload

interface DtoGuaranteedRequestPluginApi : DtoGuaranteedRequest
{
  val pluginApiRequest: DtoPluginApiRequestPayload
}