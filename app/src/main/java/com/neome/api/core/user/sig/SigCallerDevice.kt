// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import java.util.Date
import com.neome.api.meta.base.Types.DeviceId
import com.neome.api.nucleus.base.sig.SigVersion

interface SigCallerDevice : SigVersion
{
  val creationTime: String
  val deviceId: DeviceId
  val deviceName: String?
  val deviceToken: String?
  val randomColor: String
  val refreshTokenExpiry: String
}