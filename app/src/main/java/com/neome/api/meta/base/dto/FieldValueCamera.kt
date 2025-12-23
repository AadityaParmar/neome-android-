// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Date
import com.neome.api.meta.base.dto.FieldValueEntUserId
import com.neome.api.meta.base.dto.FieldValueImage
import com.neome.api.meta.base.dto.FieldValueLocation

open class FieldValueCamera : FieldValueImage()
{
  var captureLocation: FieldValueLocation? = null
  var captureTime: String? = null
  var captureUser: FieldValueEntUserId? = null
}