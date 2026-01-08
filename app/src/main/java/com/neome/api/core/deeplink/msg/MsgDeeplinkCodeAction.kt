// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.msg

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.core.deeplink.msg.MsgDeeplinkCode

interface MsgDeeplinkCodeAction : MsgDeeplinkCode
{
  val formValueRaw: FormValueRaw?
}