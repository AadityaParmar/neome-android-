// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.msg

import com.neome.api.meta.base.Types.DeviceId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.meta.base.Types.RequestId
import com.neome.api.meta.base.Types.UserId

class MsgMediaRequest : Msg() {
    var callerDeviceId: DeviceId? = null
    var callerId: UserId? = null
    var cmd: string? = null
    var entId: EntId? = null
    var entUserId: EntUserId? = null
    var expiry: number? = null
    var fileName: string? = null
    var length: number? = null
    var mediaId: MediaId? = null
    var offset: number? = null
    var requestId: RequestId? = null
}
