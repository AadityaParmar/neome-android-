// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GeoPoint

class FieldDtoLocation {
    var address: string? = null
    var city: string? = null
    var country: string? = null
    var dateTime: string? = null
    var entUserId: EntUserId? = null
    val geoPoint: GeoPoint
}
