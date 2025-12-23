// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.GeoPoint

open class FieldDtoLocation
{
  var address: String? = null
  var city: String? = null
  var country: String? = null
  var dateTime: String? = null
  var entUserId: EntUserId? = null
  lateinit var geoPoint: GeoPoint
}