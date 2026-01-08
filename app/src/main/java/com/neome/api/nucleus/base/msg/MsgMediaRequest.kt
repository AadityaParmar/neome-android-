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

interface MsgMediaRequest : Msg
{
  val callerDeviceId: DeviceId?
  val callerId: UserId?
  val cmd: String?
  val entId: EntId?
  val entUserId: EntUserId?
  val expiry: Long?
  val fileName: String?
  val length: Long?
  val mediaId: MediaId?
  val offset: Long?
  val requestId: RequestId?
}