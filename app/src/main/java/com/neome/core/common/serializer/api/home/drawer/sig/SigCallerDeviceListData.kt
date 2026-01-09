package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.core.base.dto.DtoDevice
import com.neome.api.home.drawer.sig.SigCallerDeviceList
import com.neome.api.nucleus.base.sig.Sig
import kotlinx.serialization.Serializable


@Serializable
data class SigCallerDeviceListData(
    override val deviceList: Array<DtoDevice>
) : SigCallerDeviceList
