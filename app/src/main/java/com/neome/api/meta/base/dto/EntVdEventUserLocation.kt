// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdEvent
import com.neome.api.meta.base.dto.StudioDtoLocationCapture

open class EntVdEventUserLocation : EntVdEvent()
{
  var locationCapture: StudioDtoLocationCapture? = null
}