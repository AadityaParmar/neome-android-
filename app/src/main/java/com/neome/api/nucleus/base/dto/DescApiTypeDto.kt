// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import com.neome.api.nucleus.base.dto.DescApiType

interface DescApiTypeDto : DescApiType
{
  val dtoDir: String
  val fieldMapJava: Map<String, String>?
  val fieldMapTypeScript: Map<String, String>?
  val importMap: Map<String, String>?
  val superClass: String?
}