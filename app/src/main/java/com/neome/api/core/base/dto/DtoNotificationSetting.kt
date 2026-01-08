// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.dto.GsonCto

interface DtoNotificationSetting : GsonCto
{
  val mute: Boolean?
}