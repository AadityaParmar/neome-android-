// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.msg

import com.neome.api.meta.base.Types.DeviceId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MediaId
import com.neome.api.nucleus.base.msg.Msg
import com.neome.api.meta.base.Types.RequestId
import com.neome.api.meta.base.Types.UserId

open class MsgMediaRequest : Msg()
{
  var callerDeviceId: DeviceId? = null
  var callerId: UserId? = null
  var cmd: String? = null
  var entId: EntId? = null
  var entUserId: EntUserId? = null
  var expiry: Number? = null
  var fileName: String? = null
  var length: Number? = null
  var mediaId: MediaId? = null
  var offset: Number? = null
  var requestId: RequestId? = null
}