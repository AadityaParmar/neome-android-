// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueEntUserId
import com.neome.api.meta.base.dto.FieldValueLocation

interface FieldValueSignature
{
  val captureLocation: FieldValueLocation?
  val captureTime: String?
  val captureUser: FieldValueEntUserId?
  val handle: String
  val signature: String
}