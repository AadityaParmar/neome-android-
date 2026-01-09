package com.neome.core.common.serializer.api.home.base.msg

import com.neome.api.home.base.msg.MsgDeviceId
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.DeviceIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgDeviceIdData(
    @Serializable(with = DeviceIdSer::class) override val deviceId: Types.DeviceId
) : MsgDeviceId
