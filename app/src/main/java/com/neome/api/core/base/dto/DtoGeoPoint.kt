// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.GeoPoint

class DtoGeoPoint {
    var accuracy: number? = null
    val dateTime: string
    val geoPoint: GeoPoint
}
