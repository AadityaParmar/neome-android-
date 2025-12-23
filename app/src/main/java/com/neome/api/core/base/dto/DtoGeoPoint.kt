// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.GeoPoint

open class DtoGeoPoint
{
  var accuracy: Number? = null
  lateinit var dateTime: String
  lateinit var geoPoint: GeoPoint
}