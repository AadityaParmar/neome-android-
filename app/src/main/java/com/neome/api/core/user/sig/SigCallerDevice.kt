// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.user.sig

import com.neome.api.meta.base.Types.DeviceId
import com.neome.api.nucleus.base.sig.SigVersion

open class SigCallerDevice : SigVersion() {
    lateinit var creationTime: String
    lateinit var deviceId: DeviceId
    var deviceName: String? = null
    var deviceToken: String? = null
    lateinit var randomColor: String
    lateinit var refreshTokenExpiry: String
}
