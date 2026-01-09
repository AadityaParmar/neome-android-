package com.neome.core.common.serializer.api.core.user.sig

import com.neome.api.core.user.sig.SigCallerDevice
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.DeviceIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigCallerDeviceData(
    override val version: String,
    override val creationTime: String,
    @Serializable(with = DeviceIdSer::class) override val deviceId: Types.DeviceId,
    override val deviceName: String? = null,
    override val deviceToken: String? = null,
    override val randomColor: String,
    override val refreshTokenExpiry: String
) : SigCallerDevice
