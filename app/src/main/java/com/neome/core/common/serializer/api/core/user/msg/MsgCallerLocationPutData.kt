package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.base.dto.DtoGeoPoint
import com.neome.api.core.user.msg.MsgCallerLocationPut
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgCallerLocationPutData(
    override val geoPoints: Array<DtoGeoPoint>
) : MsgCallerLocationPut
