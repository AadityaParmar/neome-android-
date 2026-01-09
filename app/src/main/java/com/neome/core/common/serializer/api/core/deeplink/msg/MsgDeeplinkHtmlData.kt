package com.neome.core.common.serializer.api.core.deeplink.msg

import com.neome.api.core.deeplink.msg.MsgDeeplinkHtml
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.Types.EnumFormExportType
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgDeeplinkHtmlData(
    override val deeplinkCode: String,
    override val deviceName: String? = null,
    override val deviceType: EnumDeviceType? = null,
    override val exportType: EnumFormExportType? = null,
    override val height: Long? = null,
    override val width: Long? = null
) : MsgDeeplinkHtml
