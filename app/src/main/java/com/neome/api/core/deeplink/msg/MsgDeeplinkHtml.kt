// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.deeplink.msg

import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.EnumFormExportType
import com.neome.api.nucleus.base.msg.Msg

open class MsgDeeplinkHtml : Msg() {
    lateinit var deeplinkCode: String
    var deviceName: String? = null
    var deviceType: EnumDeviceType? = null
    var exportType: EnumFormExportType? = null
    var height: Number? = null
    var width: Number? = null
}
