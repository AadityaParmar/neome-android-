// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.GsonCto

open class MobileNumber : GsonCto()
{
  var countryCode: Number? = null
  var nationalNumber: Number? = null
}