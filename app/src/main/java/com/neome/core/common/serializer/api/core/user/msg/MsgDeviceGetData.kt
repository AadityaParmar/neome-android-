package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.core.user.msg.MsgDeviceGet
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.DeviceIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgDeviceGetData(
    override val version: String? = null,
    @Serializable(with = DeviceIdSer::class) override val deviceId: Types.DeviceId
) : MsgDeviceGet
