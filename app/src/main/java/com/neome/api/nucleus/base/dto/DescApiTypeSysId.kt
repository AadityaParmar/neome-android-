// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType

interface DescApiTypeSysId : DescApiType
{
  val importRef: String?
  val superClass: String
  val value: String
}