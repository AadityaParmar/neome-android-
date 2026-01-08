// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.GeoPoint

interface DtoGeoPoint
{
  val accuracy: Long?
  val dateTime: String
  val geoPoint: GeoPoint
}