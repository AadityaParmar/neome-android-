// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.EnumFormExportType
import com.neome.api.nucleus.base.msg.Msg

interface MsgDeeplinkHtml : Msg
{
  val deeplinkCode: String
  val deviceName: String?
  val deviceType: EnumDeviceType?
  val exportType: EnumFormExportType?
  val height: Long?
  val width: Long?
}