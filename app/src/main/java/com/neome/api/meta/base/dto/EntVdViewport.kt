// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase

interface EntVdViewport : StudioBase
{
  val x: Long?
  val y: Long?
  val zoom: Long?
}