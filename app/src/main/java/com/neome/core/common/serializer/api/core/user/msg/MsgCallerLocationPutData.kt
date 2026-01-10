package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.base.dto.DtoGeoPoint
import com.neome.api.core.user.msg.MsgCallerLocationPut
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.core.base.dto.DtoGeoPointData
import kotlinx.serialization.Serializable


@Serializable
data class MsgCallerLocationPutData(
    override val geoPoints: List<DtoGeoPointData>
) : MsgCallerLocationPut
