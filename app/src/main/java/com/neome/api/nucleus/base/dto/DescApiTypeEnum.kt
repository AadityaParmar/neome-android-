// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType
import java.util.Set

open class DescApiTypeEnum : DescApiType()
{
  lateinit var valueSet: Array<String>
}