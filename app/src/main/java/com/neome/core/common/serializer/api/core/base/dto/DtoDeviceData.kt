package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoDevice
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.DeviceIdSer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class DtoDeviceData(
    override val creationTime: String,
    @Serializable(with = DeviceIdSer::class) override val deviceId: Types.DeviceId,
    override val deviceName: String? = null,
    override val isCurrentDevice: Boolean? = null,
    override val isOnline: Boolean? = null,
    override val lastOnlineTime: String? = null,
    override val state: JsonElement
) : DtoDevice
