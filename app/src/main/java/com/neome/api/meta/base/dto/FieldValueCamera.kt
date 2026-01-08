// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueEntUserId
import com.neome.api.meta.base.dto.FieldValueImage
import com.neome.api.meta.base.dto.FieldValueLocation

interface FieldValueCamera : FieldValueImage
{
  val captureLocation: FieldValueLocation?
  val captureTime: String?
  val captureUser: FieldValueEntUserId?
}