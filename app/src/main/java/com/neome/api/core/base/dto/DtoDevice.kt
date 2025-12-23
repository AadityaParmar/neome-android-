// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.DeviceId

open class DtoDevice {
    lateinit var creationTime: String
    lateinit var deviceId: DeviceId
    var deviceName: String? = null
    var isCurrentDevice: Boolean? = null
    var isOnline: Boolean? = null
    var lastOnlineTime: String? = null
    lateinit var state: Object
}
