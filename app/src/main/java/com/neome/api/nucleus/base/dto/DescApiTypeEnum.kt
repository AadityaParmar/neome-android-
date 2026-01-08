// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType
import java.util.Set

interface DescApiTypeEnum : DescApiType
{
  val valueSet: Array<String>
}