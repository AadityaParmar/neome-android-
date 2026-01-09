package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigReverseGeocode
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.FieldDtoLocation
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.sysId.GeoPointSer
import kotlinx.serialization.Serializable


@Serializable
data class SigReverseGeocodeData(
    override val map: Map<@Serializable(with = GeoPointSer::class) Types.GeoPoint, FieldDtoLocation>
) : SigReverseGeocode
