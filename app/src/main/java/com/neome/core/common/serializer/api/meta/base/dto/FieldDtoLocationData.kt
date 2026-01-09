package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoLocation
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.GeoPointSer
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoLocationData(
    override val address: String? = null,
    override val city: String? = null,
    override val country: String? = null,
    override val dateTime: String? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId? = null,
    @Serializable(with = GeoPointSer::class) override val geoPoint: Types.GeoPoint
) : FieldDtoLocation
