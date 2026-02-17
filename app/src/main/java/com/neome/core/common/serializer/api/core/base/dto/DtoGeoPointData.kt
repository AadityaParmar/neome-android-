package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoGeoPoint
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.GeoPointSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoGeoPointData(
    override val accuracy: Double? = null,
    override val dateTime: String,
    @Serializable(with = GeoPointSer::class) override val geoPoint: Types.GeoPoint
) : DtoGeoPoint
