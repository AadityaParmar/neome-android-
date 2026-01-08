// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.nucleus.base.dto

import java.util.Map
import com.neome.api.nucleus.base.dto.SpecApi

interface DescApiCall
{
  val call: Map<String, SpecApi>?
  val importMap: Map<String, String>?
  val pathSeg: String
}