package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldValueGeoPoint
import com.neome.core.common.serializer.sysId.GeoPointSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueGeoPointData(
    @Serializable(with = GeoPointSer::class) override val value: Types.GeoPoint
) : FieldValueGeoPoint
