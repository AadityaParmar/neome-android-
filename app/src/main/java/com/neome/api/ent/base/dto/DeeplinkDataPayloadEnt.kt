// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.core.base.dto.DeeplinkDataPayload
import com.neome.api.ent.base.dto.DeeplinkDataPayloadEntHeader

open class DeeplinkDataPayloadEnt : DeeplinkDataPayload()
{
  var header: DeeplinkDataPayloadEntHeader? = null
}