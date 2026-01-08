// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType

interface DescApiTypeBasic : DescApiType
{
  val importRef: String?
  val superCls: String?
  val value: String
}