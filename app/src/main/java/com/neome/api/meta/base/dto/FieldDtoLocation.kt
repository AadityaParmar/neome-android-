// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GeoPoint

interface FieldDtoLocation
{
  val address: String?
  val city: String?
  val country: String?
  val dateTime: String?
  val entUserId: EntUserId?
  val geoPoint: GeoPoint
}