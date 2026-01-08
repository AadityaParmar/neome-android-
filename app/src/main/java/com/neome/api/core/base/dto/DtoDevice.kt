// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.DeviceId

interface DtoDevice
{
  val creationTime: String
  val deviceId: DeviceId
  val deviceName: String?
  val isCurrentDevice: Boolean?
  val isOnline: Boolean?
  val lastOnlineTime: String?
  val state: Object
}