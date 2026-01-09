package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgReverseGeocode
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.GeoPointSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgReverseGeocodeData(
    override val geoPoints: Array<@Serializable(with = GeoPointSer::class) Types.GeoPoint>
) : MsgReverseGeocode
