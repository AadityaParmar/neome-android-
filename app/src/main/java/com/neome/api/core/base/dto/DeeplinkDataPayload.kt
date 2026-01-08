// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.core.base.Types.EnumDeeplinkActionType

interface DeeplinkDataPayload
{
  val deeplinkActionType: EnumDeeplinkActionType
}