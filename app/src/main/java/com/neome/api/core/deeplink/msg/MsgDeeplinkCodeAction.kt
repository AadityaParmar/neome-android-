// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.msg

import com.neome.api.meta.base.dto.FormValueRaw

class MsgDeeplinkCodeAction : MsgDeeplinkCode() {
    var formValueRaw: FormValueRaw? = null
}
