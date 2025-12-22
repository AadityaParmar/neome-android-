// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.meta.base.Types.DeviceId
import com.neome.api.nucleus.base.sig.SigVersion

class SigCallerDevice : SigVersion() {
    val creationTime: string
    val deviceId: DeviceId
    var deviceName: string? = null
    var deviceToken: string? = null
    val randomColor: string
    val refreshTokenExpiry: string
}
